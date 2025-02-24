package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private Car car;
    private GraphicsContext gc;
    private Image mazeImage;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(600, 400);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        mazeImage = new Image(getClass().getResource("/images/maze.png").toExternalForm());

        car = new Car(100, 100);

        Scene scene = new Scene(root, 600, 400, Color.WHITE);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) car.moveLeft();
            if (event.getCode() == KeyCode.RIGHT) car.moveRight();
            if (event.getCode() == KeyCode.UP) car.moveForward();
            if (event.getCode() == KeyCode.DOWN) car.moveBack();
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawScene();
            }
        };
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Game with Car");
        primaryStage.show();
    }

    private void drawScene() {
        gc.clearRect(0, 0, 600, 400);
        gc.drawImage(mazeImage, 50, 50);
        car.draw(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
