package FinalProject;

import java.awt.*;

public class Player extends GameObject {
    private int pucks; // # of pucks (max 3)
    private int screenWidth;
    private int lives;

    public Player(int x, int screenHeight, int screenWidth, int hudHeight) {
        super(x, screenHeight - hudHeight - 50, 50, 50, 15);
        this.pucks = 0;
        this.screenWidth = screenWidth;
        this.lives = 3;
    }
    public int getLives(){
        return lives;
    }
    public void loseLife(){
        lives--;
    }
    public void gainLife(){
        if(lives < 3 ) lives+=1;
    }
    public void reset(int screenHeight, int hudHeight){
        this.lives = 3; // reset lives + position
        this.x = screenWidth / 2;
        this.y = screenHeight - hudHeight - 50 - 10;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }
    public void moveLeft() {
        if(x > 0) x -= speed;
    }
    public void moveRight() {
        if(x < screenWidth-50) x += speed; //prevent going off screen
    }

    public void collectPuck() {
        if(pucks < 3) {
            pucks++;
        }
    }
    public void shootPuck() {
        if( pucks > 0) pucks --; // Lose a puck when shooting
    }
    public int getPucks(){
        return pucks;
    }
}
