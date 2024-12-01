package src;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Player {

    // Player attributes
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;

    // Movement flags
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    PointerInfo mouseInfo;

    // Constructor
    public Player(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    // Handle key press
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_LEFT) isMovingLeft = true;
        if (key == KeyEvent.VK_RIGHT) isMovingRight = true;
        if (key == KeyEvent.VK_UP) isMovingUp = true;
        if (key == KeyEvent.VK_DOWN) isMovingDown = true;
    }

    // Handle key release
    public void keyReleased(int key) {
        if (key == KeyEvent.VK_LEFT) isMovingLeft = false;
        if (key == KeyEvent.VK_RIGHT) isMovingRight = false;
        if (key == KeyEvent.VK_UP) isMovingUp = false;
        if (key == KeyEvent.VK_DOWN) isMovingDown = false;
    }

    // Update player's position
    public void update(int panelWidth, int panelHeight) {
        if (isMovingLeft && x > 0) x -= speed;
        if (isMovingRight && x < panelWidth - width) x += speed;
        if (isMovingUp && y > 0) y -= speed;
        if (isMovingDown && y < panelHeight - height) y += speed;
    }

    // Draw player
    public void draw(Graphics g, int panelWidth, int panelHeight) {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, panelWidth, panelHeight);

        // Player
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public void pointer(Component panel) {
        mouseInfo = MouseInfo.getPointerInfo();
    
        // Get mouse location relative to screen
        Point mouseLocation = mouseInfo.getLocation();
    
        // Get panel location on the screen
        Point panelLocation = panel.getLocationOnScreen();
    
        // Calculate relative mouse position
        double mouseX = mouseLocation.getX() - panelLocation.getX();
        double mouseY = mouseLocation.getY() - panelLocation.getY();
    
        // Calculate differences relative to player's center
        double dx = mouseX - (x + width / 2.0);
        double dy = mouseY - (y + height / 2.0);
    
        // Calculate angle in radians
        double angleRadians = Math.atan2(dy, dx);
    
        // Convert to degrees
        double angleDegrees = Math.toDegrees(angleRadians);
    
        // Print angles (for debugging)
        System.out.println("Angle in radians: " + angleRadians);
        System.out.println("Angle in degrees: " + angleDegrees);
        
        
        
        
        
        
    }
}
