package FinalProject;

public class Player extends GameObject {
    private int pucks; // Number of pucks (max 3)

    public Player(int x, int y) {
        super(x, y, 5);
        this.pucks = 0;
    }

    public void moveLeft() {
        x -= speed;
    }
    public void moveRight() {
        x += speed;
    }

    public void collectPuck() {
        if(pucks < 3) {
            pucks++;
        }
        else{
            pucks--;
        }
    }
    public int getPucks(){
        return pucks;
    }
}
