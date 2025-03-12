package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TheGauntlet extends JPanel implements ActionListener, KeyListener {
    private int playerX = 250; // Player starts in the middle
    private final int playerWidth = 50;
    private final int screenWidth = 500, screenHeight = 800;
    private Timer timer;
    private GameManager gameManager;
    private boolean movingLeft = false, movingRight = false;

    public TheGauntlet() {
        showHowToPlay(); // show instructions before game starts

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(this);

        gameManager = new GameManager(screenWidth, screenHeight, this);
        timer = new Timer(30, this); //Game loop (30ms)
        timer.start();
    }
    private void showHowToPlay(){
        String instructions = "Welcome to The Gauntlet! \n\n"
                + "- Use LEFT & RIGHT arrow keys to move.\n "
                + "- Avoid blue defenders or body-check them from the side (+1 point).\n "
                + "- Collect pucks and score in the net (+10 points, +1 life).\n "
                + "     - Can carry max 3 pucks at a time. If you try to pick up a 4th, you fumble and remain with 2 pucks.\n "
                + "- Lose a life when you:\n "
                + "     - hit a net without carrying a puck\n "
                + "     - collide head-on with a defender\n "
                + "- Survive as long as possible and rack up points!\n\n "
                + "Press OK to start.";
        JOptionPane.showMessageDialog(null, instructions, "How to Play", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw player
        gameManager.getPlayer().draw(g);

        //Draw moving objects (defenders, pucks, nets)
        for(Defender d : gameManager.getDefenders()) d.draw(g);
        for(Puck p : gameManager.getPucks()) p.draw(g);
        for(Net n : gameManager.getNets()) n.draw(g);

        drawHUD(g);
    }

    private void drawHUD(Graphics g){
        int hudHeight = 60;
        int hudY = screenHeight - hudHeight; // position HUD at the bottom
    
        g.setColor(new Color(255,255,255,180)); // white with transparency
        g.fillRect(0, hudY, screenWidth, hudHeight);
    
        // Display time, score, pucks, and lives
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("# of Pucks: "+gameManager.getPucksHeld()+" /3", 20, hudY + 25);
        g.setColor(Color.RED);
        g.drawString("Lives: " + gameManager.getPlayer().getLives(), 300, hudY + 25);
        g.setColor(Color.BLUE);
        g.drawString("Time: " + gameManager.getGameTimeSeconds() + "s", 20, hudY + 50);
        g.drawString("Score: " + gameManager.getScore(), 300, hudY + 50);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(movingLeft) gameManager.getPlayer().moveLeft();
        if(movingRight) gameManager.getPlayer().moveRight();
        gameManager.spawnObjects(); // spawn objects
        gameManager.updateGame(); // Move objects
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT && playerX >0){
            movingLeft = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && playerX < screenWidth-playerWidth){
            movingRight = true;
        }
    }

    @Override public void keyReleased(KeyEvent e){ 
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            movingLeft = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            movingRight = false;
        }
    }
    public void resetMovement(){
        movingLeft = false;
        movingRight = false;
    }
    
    // Getters to check movement status
    public boolean isMovingLeft() {
        return movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }
    
    @Override public void keyTyped(KeyEvent e){}

    public static void main(String[] args) {
        JFrame frame = new JFrame("The Gauntlet");
        TheGauntlet game = new TheGauntlet();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
