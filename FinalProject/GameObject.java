package FinalProject;

public abstract class GameObject {
    protected int x, y; // Position
    protected int speed;

    public GameObject(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public abstract void update(); // Each object updates itself

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
