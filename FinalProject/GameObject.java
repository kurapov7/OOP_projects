package FinalProject;

import java.awt.*;

public abstract class GameObject {
    protected float x, y, width, height, speed; // Position

    public GameObject(int x, int y, int width, int height, int speed) {
        this.x = x; 
        this.y = (float) y;
        this.width = width; this.height = height;
        this.speed = speed;
    }
    public void setSpeed(float newSpeed){
        this.speed = newSpeed;
    }
    public void moveDown() {
        y += speed;
    }
    
    public abstract void draw(Graphics g);

    public int getX(){
        return (int) x;
    }
    public int getY(){
        return (int) y;
    }
    public int getWidth(){
        return (int) width;
    }
    public int getHeight(){
        return (int) height;
    }
    public boolean checkCollision(GameObject other) {
        return this.x < other.getX() + other.getWidth() &&
               this.x + this.width > other.getX() &&
               this.y < other.getY() + other.getHeight() &&
               this.y + this.height > other.getY();
    }
}
