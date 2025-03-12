package FinalProject;

import java.awt.*;

public class Defender extends GameObject implements Movable {
    public Defender(int x, int y){
        super(x, y, 50, 50, 5);
    }
    @Override
    public void move(){
        moveDown();
    }
    @Override
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect((int)x, (int) y, (int) width, (int) height);
    }

    
}
