package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-application.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 532);

        // Get controller instance
        MainController controller = fxmlLoader.getController();

        // Attach key listener for robot movement
        scene.setOnKeyPressed(controller::handleKeyPress);

        stage.setTitle("Hello!");cl
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
