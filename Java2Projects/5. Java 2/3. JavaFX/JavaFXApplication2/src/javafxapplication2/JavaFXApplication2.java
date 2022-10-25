/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication2;

import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class JavaFXApplication2 extends Application {
    
    static int count;
    
    @Override
    public void start(Stage primaryStage) {
        Label lbl = new Label("CSS is cool!");
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        
        Button btn1 = new Button("Add data");
        btn1.setOnAction((event) -> {
            list.add(new PieChart.Data("Data-" + count, new Random().nextInt(30)+10));
            count++;
        });
        
        Button btn2 = new Button("Remove data");
        btn2.setOnAction((event) -> {
            if(!list.isEmpty()) list.remove(new Random().nextInt(list.size()));
        });
        
        FlowPane root = new FlowPane(); // Pane - разметка приложения
        PieChart pch = new PieChart(list);
        
        root.getChildren().add(lbl);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(pch);
        //root.getChildren().add(new Sphere(50));
        
        Scene scene = new Scene(root, 450, 500); // через scene меняется внешний вид приложения.
        scene.getStylesheets().add(getClass().getResource("CascadeSS.css").toExternalForm()); // to ExternalForm  -преобразует универсальный идентификатор (URL) в строку, понятную для handler-а (обработчика)add формат.
        
        primaryStage.setTitle("Data demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
