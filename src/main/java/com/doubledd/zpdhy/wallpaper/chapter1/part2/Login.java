package com.doubledd.zpdhy.wallpaper.chapter1.part2;

import com.doubledd.zpdhy.wallpaper.utils.StringUtils;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.System.out;


public class Login extends Application {

    public static void main(String[] args) {
        Application.launch(Login.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // 增加文本(Text)、标签(Label)和文本域(Text Field)
        // text
        Text text = new Text("welcome");
        gridPane.add(text, 0, 0, 2, 1);
        text.setId("welcome-text");

        //创建Label对象，放到第0列，第1行
        Label usernameLabel = new Label("username");
        gridPane.add(usernameLabel, 0, 1);

        //创建文本输入框，放到第1列，第1行
        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);

        Label passwordLabel = new Label("password");
        gridPane.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);


        //debug 显示网格线
//        gridPane.setGridLinesVisible(true);


        // 按钮
        Button signIn = new Button("sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(signIn);
        gridPane.add(hBox, 1, 4);

        Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 6);
        actiontarget.setId("actiontarget");


        signIn.setOnAction(e -> {
            String username = userTextField.getText();
            out.println("username: " + username);
            String password = passwordField.getText();
            out.println("password: " + password);
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                actiontarget.setText("username or password invalid");
            } else {
                actiontarget.setText("ok");
            }
        });
        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("/chapter1/styles/Login.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.show();
    }


}
