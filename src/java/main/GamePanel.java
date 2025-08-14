package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int originalTileSize = 16;
    public static final float scale = 2;
    public static final int tileSize = (int) (originalTileSize * scale);

    public static final int windowWidth = 1000;
    public static final int windowHeight = 600;

    public static final int FPS = 60;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000d / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                delta--;
                update(delta);
                repaint();
            }
        }
    }

    public void update(double delta) {

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
    }
}
