package com.example.myloginjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

// This class launches the application and sets the scene to the login-view
public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480 , 480);
        // sets the title (bar at the top of window)
        stage.setTitle("Welcome to the Login Page");
        stage.initStyle(StageStyle.UTILITY);  // removes minimise and maximise options on window
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}