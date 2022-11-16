package javafxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class GridPaneController implements Initializable {

    @FXML
    public void btnFindClick(ActionEvent event){
        System.out.println("Find!");
    }
    
    @FXML
    public void btnCancelClik(ActionEvent event){
        System.out.println("Try to Cancel!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
