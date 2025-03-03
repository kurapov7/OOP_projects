package FinalProject;

public class Game {
    private Player player;

    public Game(){
        player = new Player(250,50); // Start position
    }
    public void updateGame() {
        player.update(); // update defenders, nets, pucks
    }

    public void run() {
        while (true) {
            updateGame();
            try{ 
                Thread.sleep(16); 
            }catch(InterruptedException e){
                // do nothing
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
