import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements  Runnable {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    boolean isRunning = false;
    BufferedImage image;
    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler();
    int FPS = 60;

    // Set player
    int playerX = 500;
    int playerY = 500;
    int playerSpeed = 1;

    GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);

    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start(); //Calls run method
    }

    @Override
    public void run() {
        double drawTime = 100000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/ drawTime;
            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();  //Calls paintComponent
                delta--;
            }
        }
    }

    public void update() {
        if (keyHandler.leftPressed == true) {
            playerX -= playerSpeed;
        }
        if (keyHandler.rightPressed == true) {
            playerX += playerSpeed;
        }
        if (keyHandler.spacePressed == true) {
            // It needs to calculate for how long it is hold then perform jump
            playerY -= playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, 40, 40);

        g2.dispose();
    }

    public void draw(Graphics g) {
    }

    public void move() {

    }

    public void jump() {

    }

    public void checkCollisions() {

    }

    public void gameOver(Graphics g) {

    }

}
