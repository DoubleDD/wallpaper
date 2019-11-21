package com.doubledd.zpdhy.wallpaper.chapter1.part3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * @author XPS
 */
public class Login extends Application {

    public static void main(String[] args) {
        Application.launch(Login.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/chapter1/layout/fxml_example.fxml"));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
