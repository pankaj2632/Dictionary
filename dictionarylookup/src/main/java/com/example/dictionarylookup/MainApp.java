package com.example.dictionarylookup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the main search view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/dictionarylookup/SearchView.fxml"));
        Scene scene = new Scene(loader.load());

        // Set the stage properties
        primaryStage.setTitle("Dictionary Lookup");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/dictionarylookup/app_icon.png"))); // Set a custom icon
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Optional: Disable resizing
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
