package FinalProject;

import java.awt.*;

public class Net extends GameObject implements Movable {
    public Net(int x, int y) {
        super(x, y, 50, 50, 5);
    }

    @Override
    public void move() {
        moveDown();
    }
    @Override
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.drawRect((int) x, (int) y, (int) width, (int) height);
    }
}
