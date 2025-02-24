package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Car {
    private double x, y;
    private final double width, height;
    private final double speed;

    public Car(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 40;
        this.speed = 8;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, width, height);

        gc.setFill(Color.BLACK);
        gc.fillRect(x + 5, y + height, 10, 10);
        gc.fillRect(x + width - 15, y + height, 10, 10);
    }


    public void moveLeft() { x -= speed; }
    public void moveRight() { x += speed; }
    public void moveUp() { y -= speed; }
    public void moveDown() { y += speed; }


    public double getX() { return x; }
    public double getY() { return y; }


    public void stopAtBoundary(double minX, double maxX, double minY, double maxY) {
        if (x < minX) x = minX;
        if (x + width > maxX) x = maxX - width;
        if (y < minY) y = minY;
        if (y + height > maxY) y = maxY - height;
    }
}
