package com.doubledd.zpdhy.wallpaper.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Wallpaper extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/main/layout/wallpaper.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("壁纸");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
