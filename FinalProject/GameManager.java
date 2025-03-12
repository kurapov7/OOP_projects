package FinalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    private List<Defender> defenders;
    private List<Puck> pucks;
    private List<Net> nets;
    private Player player;
    private int screenWidth, screenHeight;
    private Random rand;
    private TheGauntlet game;
    private int score; 
    private int pucksHeld; // amount of pucks player is holding
    private int gameTimeSeconds; // Total seconds player survives
    private static final int MAX_PUCKS = 3;
    private boolean gameOver;
    private static final int HUD_HEIGHT = 60;
    private long startTime;
    private float baseSpeed = 3.0f;
    private float currentSpeed;

    public GameManager(int screenWidth, int screenHeight, TheGauntlet game) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.game = game;
        this.startTime = System.currentTimeMillis();
        player = new Player(screenWidth / 2, screenHeight, screenWidth, HUD_HEIGHT);
        defenders = new ArrayList<>();
        pucks = new ArrayList<>();
        nets = new ArrayList<>();
        rand = new Random();
        
        gameOver = false;
        score = 0;
        pucksHeld = 0;
        gameTimeSeconds = 0;

        currentSpeed = baseSpeed; // initial speed
        ScoreManager.setGameManager(this);
    }
    public List<Defender> getDefenders(){
        return defenders;
    }
    public List<Puck> getPucks(){
        return pucks;
    }
    public List<Net> getNets(){
        return nets;
    }

    public void spawnObjects() {
        int columns = 5;
        int columnWidth = screenWidth / columns;
       
        if (rand.nextInt(100) < 10) { // 10% chance to spawn defender
            int col = rand.nextInt(columns);
            int x = col * columnWidth + 10;
            if (!isColliding(x, 0, defenders)) {
                defenders.add(new Defender(x, 0));
            }
        }
    
        if (rand.nextInt(100) < 5) { // 6% chance to spawn puck
            int col = rand.nextInt(columns);
            int x = col * columnWidth + 20;
            if (!isColliding(x, 0, pucks)) {
                pucks.add(new Puck(x, 0));
            }
        }
    
        if (rand.nextInt(100) < 4) { // 5% chance to spawn net
            int col = rand.nextInt(columns);
            int x = col * columnWidth + 30;
            if (!isColliding(x, 0, nets)) {
                nets.add(new Net(x, 0));
            }
        }
    }
    private <T extends GameObject> boolean isColliding(int x, int y, List<T> objects) {
        for (T obj : objects) {
            if (Math.abs(obj.getX() - x) < 50 && Math.abs(obj.getY() - y) < 100) {
                return true; // if too close, don't spawn
            }
        }
        return false;
    }
    public void updateGame() {
        if (gameOver) return;

        gameTimeSeconds = (int)((System.currentTimeMillis()-startTime) / 1000);
        currentSpeed = baseSpeed + (gameTimeSeconds / 10) * 0.7f;

        defenders.removeIf(d -> d.getY() > screenHeight-75); // Remove objects off-screen
        pucks.removeIf(p -> p.getY() > screenHeight-75);
        nets.removeIf(n -> n.getY() > screenHeight-75);

        for (Defender d : defenders) {
            d.setSpeed(currentSpeed);
            d.move();
        }
        for (Puck p : pucks) {
            p.setSpeed(currentSpeed);
            p.move();
        }
        for (Net n : nets) {
            n.setSpeed(currentSpeed);
            n.move();
        }

        handleCollisions();
        if (player.getLives() <= 0){
            int finalScore = getFinalScore();
            ScoreManager.saveNewScore(finalScore);
        }
        if(!gameOver){
            gameTimeSeconds++; // count only when game is running
        }
    }

    public void restartGame(){
        System.out.println("Restarting Game...");
        gameOver = false;
        game.resetMovement();
        player.reset(screenHeight, HUD_HEIGHT);
        defenders.clear();
        pucks.clear();
        nets.clear();
        score = 0;
        pucksHeld = 0;
        gameTimeSeconds = 0;
        startTime = System.currentTimeMillis();
        currentSpeed = baseSpeed;
        
        // Reset object speeds
        for (Defender d : defenders) d.setSpeed(currentSpeed);
        for (Puck p : pucks) p.setSpeed(currentSpeed);
        for (Net n : nets) n.setSpeed(currentSpeed);
        

        game.repaint();
        System.out.println("New Game!");
    }


    private void handleCollisions() {
        handlePlayerCollisions();
        removeOverlapping(defenders, pucks);
        removeOverlapping(defenders, nets);
        removeOverlapping(pucks, nets);
    }
    private void handlePlayerCollisions(){
        // Collisions with defenders: player can hit them from the side to eliminate them
        // if player gets hit by defender head-on, lose a life.
        for(int i = 0; i < defenders.size(); i++){
            Defender d = defenders.get(i);

            // Calculate horizontal & vertical difference
            int dx = Math.abs(player.getX()-d.getX());
            int dy = Math.abs(player.getY()-d.getY());

            // check for collision from side ("Body-check" by player!) +1 point
            if (dx < 50 && dy < 40 && (game.isMovingLeft() || game.isMovingRight())){
                defenders.remove(i);
                score += 1;
                i--; //adjust index
            }
            // check for head on collision with defender (Lose a life)
            else if (dx<50 && d.getY() > player.getY() - 40){
                player.loseLife();
                System.out.println("Lost 1 life: got hit by a defender");
                defenders.remove(i);
                i--;
            }

        }
        // collision with pucks (collect max 3)
        for (Puck puck : pucks){
            if(player.checkCollision(puck)){
                if(pucksHeld<MAX_PUCKS){
                    // player.collectPuck();
                    pucksHeld++;
                }else{
                    pucksHeld--;
                }
                pucks.remove(puck);
                break;
            }
        }
        // collision with nets: goal or no goal? if goal score +=10 and +1 life
        for (Net net : nets) {
            if(player.checkCollision(net)){
                if(pucksHeld > 0){
                    score += 10;
                    pucksHeld--;
                    if(player.getLives() == 1){
                        player.gainLife();
                        System.out.println("Goal! 1 life gained.");
                    }
                }else {
                    player.loseLife();
                    System.out.println("Lost 1 life -- hit net without a puck");
                }
                nets.remove(net);
                break;
            }
        }
    }
    public int getFinalScore(){
        return score + gameTimeSeconds; // final score = time survived + goals scored * 10
    }
    public int getGameTimeSeconds(){
        return gameTimeSeconds;
    }
    public int getScore(){
        return score;
    }
    public int getPucksHeld(){
        return pucksHeld;
    }
    private <T extends GameObject, U extends GameObject> void removeOverlapping(List<T> list1, List<U> list2) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (Math.abs(list1.get(i).getX() - list2.get(j).getX()) < 50 &&
                    Math.abs(list1.get(i).getY() - list2.get(j).getY()) < 100) {
                    // if two objects are too close, randomly decide which one to remove
                    if (rand.nextBoolean()) {
                        list1.remove(i);
                        i--; // Adjust index after removal
                        break; 
                    } else {
                        list2.remove(j);
                        j--; // Adjust index after removal
                    }
                }
            }
        }
    } 
    
    public Player getPlayer(){
        return player;
    }

}
