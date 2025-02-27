package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

public class CarController {

    @FXML
    private Pane carPane;

    private ImageView car;
    private final int STEP_SIZE = 10;
    private double angle = 0; // Car rotation angle

    @FXML
    public void initialize() {
        // Load car image
        car = new ImageView(new Image(getClass().getResource("/images/car.png").toExternalForm()));
        car.setFitWidth(60);
        car.setFitHeight(40);
        car.setX(50);
        car.setY(65);

        carPane.getChildren().add(car);
    }

    public void handleKeyPress(KeyEvent event) {
        double newX = car.getX();
        double newY = car.getY();
        double radianAngle = Math.toRadians(angle);

        switch (event.getCode()) {
            case LEFT -> angle -= 10; // Rotate Left
            case RIGHT -> angle += 10; // Rotate Right
            case UP -> { // Move Forward
                newX += STEP_SIZE * Math.cos(radianAngle);
                newY += STEP_SIZE * Math.sin(radianAngle);
            }
            case DOWN -> { // Move Backward
                newX -= STEP_SIZE * Math.cos(radianAngle);
                newY -= STEP_SIZE * Math.sin(radianAngle);
            }
        }

        // Update car's position and rotation
        car.setX(newX);
        car.setY(newY);
        car.setRotate(angle);
    }

    @FXML
    public void onResetCarButtonClick(ActionEvent event) {
        if (car != null) {
            car.setX(50);
            car.setY(65);
            car.setRotate(0);
            angle = 0;
            System.out.println("Car reset to start position.");
        }
    }
}
