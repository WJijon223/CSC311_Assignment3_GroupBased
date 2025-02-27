package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.image.PixelReader;

public class MainController {

    @FXML
    private Pane animationPane;

    @FXML
    private Button startAnimationButton;

    @FXML
    private Label welcomeText;

    @FXML
    private Button resetButton;

    private ImageView robot;
    private final int STEP_SIZE = 10; // Movement per key press
    private Image mazeImage; // Image for collision detection
    private PixelReader pixelReader; // Reads pixel colors for path validation

    @FXML
    public void initialize() {
        // Load the robot image inside the Pane
        robot = new ImageView(new Image(getClass().getResource("/images/robot.png").toExternalForm()));
        robot.setFitWidth(45);
        robot.setFitHeight(45);

        // Set correct starting position (Adjust as needed)
        robot.setX(50);  // Move to correct starting X
        robot.setY(65);  // Move to correct starting Y (Was too low before)

        animationPane.getChildren().add(robot); // Add robot to pane

        // Load the maze image for collision detection
        mazeImage = new Image(getClass().getResource("/images/maze.png").toExternalForm());
        pixelReader = mazeImage.getPixelReader();

        // Set button action to start animation
        startAnimationButton.setOnAction(this::startAnimation);
    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    void onResetButtonClick(ActionEvent event) {
        robot.setX(50); // Reset robot position
        robot.setY(65); // Reset robot position
    }

    // Handles robot movement when arrow keys are pressed
    public void handleKeyPress(KeyEvent event) {
        double newX = robot.getX();
        double newY = robot.getY();

        switch (event.getCode()) {
            case UP -> {
                newY -= STEP_SIZE;
                robot.setRotate(0); // Face Up
            }
            case DOWN -> {
                newY += STEP_SIZE;
                robot.setRotate(180); // Face Down
            }
            case LEFT -> {
                newX -= STEP_SIZE;
                robot.setRotate(270); // Face Left
            }
            case RIGHT -> {
                newX += STEP_SIZE;
                robot.setRotate(90); // Face Right
            }
        }

        // Only move if the next position is not a wall
        if (canMove(newX, newY)) {
            robot.setX(newX);
            robot.setY(newY);
        }
    }




        private void startAnimation(ActionEvent event) {
            Timeline timeline = new Timeline();

            // Movement sequence based on your instructions
            KeyFrame step1 = new KeyFrame(Duration.seconds(1), e -> moveIfValid(43, 0));  // 1 step right
            KeyFrame step2 = new KeyFrame(Duration.seconds(2), e -> moveIfValid(0, -50)); // 1 step up
            KeyFrame step3 = new KeyFrame(Duration.seconds(3), e -> moveIfValid(0, -50)); // 2nd step up
            KeyFrame step4 = new KeyFrame(Duration.seconds(4), e -> moveIfValid(68, 0));  // 1st step right
            KeyFrame step5 = new KeyFrame(Duration.seconds(5), e -> moveIfValid(68, 0));  // 2nd step right
            KeyFrame step6 = new KeyFrame(Duration.seconds(6), e -> moveIfValid(68, 0));  // 3rd step right
            KeyFrame step7 = new KeyFrame(Duration.seconds(7), e -> moveIfValid(0, -50)); // 1 step up
            KeyFrame step8 = new KeyFrame(Duration.seconds(8), e -> moveIfValid(50, 0));  // 1 step right
            KeyFrame step9 = new KeyFrame(Duration.seconds(9), e -> moveIfValid(0, 70));  // 1st step down
            KeyFrame step10 = new KeyFrame(Duration.seconds(10), e -> moveIfValid(0, 70)); // 2nd step down
            KeyFrame step11 = new KeyFrame(Duration.seconds(11), e -> moveIfValid(0, 70)); // 3rd step down
            KeyFrame step12 = new KeyFrame(Duration.seconds(12), e -> moveIfValid(50, 0)); // 1 step right
            KeyFrame step13 = new KeyFrame(Duration.seconds(13), e -> moveIfValid(0, -50)); // 1st step up
            KeyFrame step14 = new KeyFrame(Duration.seconds(14), e -> moveIfValid(0, -50)); // 2nd step up
            KeyFrame step15 = new KeyFrame(Duration.seconds(15), e -> moveIfValid(50, 0)); // 1 step right
            KeyFrame step16 = new KeyFrame(Duration.seconds(16), e -> moveIfValid(50, 0)); // 1 more step right
            KeyFrame step17 = new KeyFrame(Duration.seconds(17), e -> moveIfValid(0, -50)); // 1st step up
            KeyFrame step18 = new KeyFrame(Duration.seconds(18), e -> moveIfValid(0, -50)); // 2nd step up
            KeyFrame step19 = new KeyFrame(Duration.seconds(19), e -> moveIfValid(55, 0)); // 1 step right
            KeyFrame step20 = new KeyFrame(Duration.seconds(20), e -> moveIfValid(0, 45)); // 1st step down
            KeyFrame step21 = new KeyFrame(Duration.seconds(21), e -> moveIfValid(0, 45)); // 2nd step down
            KeyFrame step22 = new KeyFrame(Duration.seconds(22), e -> moveIfValid(0, 45)); // 3rd step down
            KeyFrame step23 = new KeyFrame(Duration.seconds(23), e -> moveIfValid(50, 0)); // 1st additional step right
            KeyFrame step24 = new KeyFrame(Duration.seconds(24), e -> moveIfValid(50, 0)); // 2nd additional step right

            // Add all steps to the timeline
            timeline.getKeyFrames().addAll(
                    step1, step2, step3, step4, step5, step6, step7, step8, step9, step10,
                    step11, step12, step13, step14, step15, step16, step17, step18, step19,
                    step20, step21, step22, step23, step24
            );
            timeline.play();
            robot.setX(50); // Reset robot position
            robot.setY(65); // Reset robot position
        }



        // Moves the robot only if the path is valid (prevents going into walls)
    private void moveIfValid(double dx, double dy) {
        double newX = robot.getX() + dx;
        double newY = robot.getY() + dy;

        if (canMove(newX, newY)) {
            robot.setX(newX);
            robot.setY(newY);
        }
    }

    // Checks if the robot can move to the new position
    private boolean canMove(double x, double y) {
        int pixelX = (int) Math.max(0, Math.min(x, mazeImage.getWidth() - 1));
        int pixelY = (int) Math.max(0, Math.min(y, mazeImage.getHeight() - 1));

        // Get pixel color at the new position
        Color pixelColor = pixelReader.getColor(pixelX, pixelY);

        // Define the wall color (Assuming walls are blue)
        Color WALL_COLOR = Color.BLUE;

        // Return true if the pixel is not a wall
        return !pixelColor.equals(WALL_COLOR);
    }

    public void onResetCarButtonClick(ActionEvent actionEvent) {
    }
}
