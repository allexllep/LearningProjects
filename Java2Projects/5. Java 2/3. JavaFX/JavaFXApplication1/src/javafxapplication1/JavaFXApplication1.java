/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author allex
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label lbl1 = new Label("Input your name: ");
        TextField txt = new TextField();
        Button btn = new Button("Print to HelloWorld!");
        Label lbl2 = new Label();
        
        btn.setOnAction((event) -> {
            if (txt.getText().isEmpty()) lbl2.setText("Hello World!");
            else lbl2.setText("Hello " + txt.getText() + "!");
        });
        
        
        GridPane root = new GridPane();
        root.add(lbl1, 0, 0);
        root.add(txt, 1, 0);
        root.add(btn, 1, 1);
        root.add(lbl2, 1, 2);
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
