package edu.farmingdale.csc311_assignment3_groupbased;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-application.fxml"));
        TabPane root = fxmlLoader.load();

        // Get main controller
        MainController mainController = fxmlLoader.getController();

        Scene scene = new Scene(root, 700, 532);

        // Attach key listener for both robot and car
        scene.setOnKeyPressed(event -> mainController.handleKeyPress(event));

        stage.setTitle("Maze Navigation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
