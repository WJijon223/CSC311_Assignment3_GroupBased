package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Car implements Movable {
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

    @Override
    public void moveLeft() { x -= speed; }
    @Override
    public void moveRight() { x += speed; }
    @Override
    public void moveForward() { y -= speed; }
    @Override
    public void moveBack() { y += speed; }

    public double getX() { return x; }
    public double getY() { return y; }
}
