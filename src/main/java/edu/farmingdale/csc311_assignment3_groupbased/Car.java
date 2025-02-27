package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Car implements Movable {
    private double x, y;
    private final double width, height;
    private final double speed;
    private double angle = 0; // Rotation angle

    public Car(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 40;
        this.speed = 8;
    }

    public void draw(GraphicsContext gc) {
        gc.save();
        rotate(gc, angle, x + width / 2, y + height / 2);
        gc.setFill(Color.RED);
        gc.fillRect(x, y, width, height);
        gc.setFill(Color.BLACK);
        gc.fillRect(x + 5, y + height, 10, 10);
        gc.fillRect(x + width - 15, y + height, 10, 10);
        gc.restore();
    }

    @Override
    public void moveLeft() {
        x -= speed;
        angle = 270;
    }

    @Override
    public void moveRight() {
        x += speed;
        angle = 90;
    }

    @Override
    public void moveForward() {
        y -= speed;
        angle = 0;
    }

    @Override
    public void moveBack() {
        y += speed;
        angle = 180;
    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
