package com.doubledd.zpdhy.wallpaper.part1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Button btn = new Button();
        btn.setText("test");
        btn.setOnAction(e-> System.out.println("awesome!!!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root,300,200);

        stage.setTitle("JavaFx");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}