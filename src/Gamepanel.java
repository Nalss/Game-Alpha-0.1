package src;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Gamepanel extends JComponent implements KeyListener {

    private Player player;

    public Gamepanel() {
        // Initialize player at a default position
        player = new Player(180, 200, 20, 30, 5);
    }

    public void openGUI() {
        // Open GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null); // Centers the window on screen
            Gamepanel gamePanel = this;
            frame.add(gamePanel);
            frame.addKeyListener(gamePanel); // Add key listener for player movement
            frame.setVisible(true); // Ensures the frame is displayed

            // Start the game loop
            startGame();
        });
    }

    // Game loop with tick speed
    public void startGame() {
        int tickSpeed = 1000 / 60; // 60 FPS for smoother animation
        Timer timer = new Timer(tickSpeed, e -> {
        updateGame(); // Update game state
        repaint();   // Repaint the screen
        });
        timer.start();
    }

    // Update game state
    public void updateGame() {
        // Update player
        player.update(getX(), getY());
    }

    // Paint the game components
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background color
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getX(), getY());

        // Draw player
        player.draw(g);
    }

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
