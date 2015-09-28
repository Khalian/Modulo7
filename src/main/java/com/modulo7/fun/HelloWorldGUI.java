package com.modulo7.fun;

/**
 * Created by asanyal on 9/27/15.
 *
 * A hello world app in java fx
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorldGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Hello and welcome to Modulo7");
        btn.setOnAction(event -> processGUIMode());

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processGUIMode() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
