package FinalProject;

import java.awt.*;

public class Puck extends GameObject implements Movable {
    public Puck(int x, int y) {
        super(x, y, 50, 50, 5);
    }

    @Override
    public void move(){
        moveDown();
    }
    @Override
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval((int) x, (int) y, (int) width, (int) height);
    }
}
