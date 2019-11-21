package com.doubledd.zpdhy.wallpaper.chapter1.part4;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ColorfulCircles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setTitle("动画");
        primaryStage.setScene(scene);

        Group circles = new Group();
        Circle circle;
        for (int i = 0; i < 30; i++) {
            circle = new Circle(100, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            // 设置画笔颜色和透明度
            circle.setStroke(Color.web("white", 0.16));
            // 设置画笔宽度
            circle.setStrokeWidth(4);
            circle.setEffect(new BoxBlur(10, 10, 3));

            circles.getChildren().add(circle);
        }

        double sceneWidth = scene.getWidth();
        double sceneHeight = scene.getHeight();
        Rectangle colors = new Rectangle(sceneWidth, sceneHeight,
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#f8bd55")),
                        new Stop(0.14, Color.web("#c0fe56")),
                        new Stop(0.28, Color.web("#5dfbc1")),
                        new Stop(0.43, Color.web("#64c2f8")),
                        new Stop(0.57, Color.web("#be4af7")),
                        new Stop(0.71, Color.web("#ed5fc2")),
                        new Stop(0.85, Color.web("#ef504c")),
                        new Stop(1, Color.web("#f2660f"))));

        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());

        //蒙版混合层
        Group blendModeGroup = new Group(new Group(new Rectangle(sceneWidth, sceneHeight, Color.BLACK), circles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);

        root.getChildren().add(blendModeGroup);

        // 增加时间线
        Timeline timeline = new Timeline();
        for (Node cle : circles.getChildren()) {
            // 增加关键帧
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(cle.translateXProperty(), Math.random() * sceneWidth),
                            new KeyValue(cle.translateYProperty(), Math.random() * sceneHeight)),
                    new KeyFrame(new Duration(40000),
                            new KeyValue(cle.translateXProperty(), Math.random() * sceneWidth),
                            new KeyValue(cle.translateYProperty(), Math.random() * sceneHeight))
            );
        }

        timeline.play();


        primaryStage.show();
    }
}
