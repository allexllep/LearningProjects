package J2JavaFX2Tasks;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class J2JavaFX2Tasks extends Application {
    public static void main(String[] args) throws InterruptedException {
        Demotask task = new Demotask();
        new Thread(task).start();
        
        DoubleProperty dp = new SimpleDoubleProperty(); 
        dp.bind(task.progressProperty()); // task.progressProperty() double от 0 до 1.
        while(!task.isDone()){
            Thread.sleep(500);
            System.out.println(dp.get()*100 + "%");
        }
        
        System.out.println("end of main");
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

class Demotask extends Task<Void>{

    @Override
    protected Void call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            //System.out.println(i);
            updateProgress(i+1, 10);
        }
        
        return null;
    }

    @Override
    protected void succeeded() {
        System.out.println("task succeeded");
    }
    
    
    
}
