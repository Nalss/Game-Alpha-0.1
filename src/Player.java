package src;
import java.awt.*;
import java.awt.event.KeyEvent;

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

    // Constructor
    public Player(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    // Getters for position and dimensions
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Key press handling
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_LEFT) isMovingLeft = true;
        if (key == KeyEvent.VK_RIGHT) isMovingRight = true;
        if (key == KeyEvent.VK_UP) isMovingUp = true;
        if (key == KeyEvent.VK_DOWN) isMovingDown = true;
    }

    // Key release handling
    public void keyReleased(int key) {
        if (key == KeyEvent.VK_LEFT) isMovingLeft = false;
        if (key == KeyEvent.VK_RIGHT) isMovingRight = false;
        if (key == KeyEvent.VK_UP) isMovingUp = false;
        if (key == KeyEvent.VK_DOWN) isMovingDown = false;
    }

    // Update player's position
    public void update(int getX, int getY) {
        if (isMovingLeft && x > 0) x -= speed;
        if (isMovingRight && x < getX - width) x += speed;
        if (isMovingUp && y > 0) y -= speed;
        if (isMovingDown && y < getY - height) y += speed;
    }

    // Draw player on the screen
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
