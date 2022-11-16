package javafxapplicationhwextra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.*;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {
    
    private Image img;
    private Task task;
    private File file;
    
    @FXML private Label pathId;
    @FXML private TableView<String> listId;
    @FXML private ImageView imageView;
    @FXML private Button btnUpload;
    
    @FXML
    private void btnUploadClick(ActionEvent event) {
        MySQL.upload(file);
    }
    
    @FXML
    private void btnSelectClick(ActionEvent event) {
        
        file = null;
        FileChooser fch = new FileChooser();
        fch.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.gif", "*.jpg", "*.jpeg"));
        file = fch.showOpenDialog(null);
        
        
        if(file != null){
            if(file.length()<=65535){
                try {
                 img = new Image(new FileInputStream(file));
                } catch (FileNotFoundException ex) {System.out.println(ex.getMessage());}
        
                imageView.setImage(img);
                pathId.setText(file.getPath());
                btnUpload.setDisable(false);
            } else {
                pathId.setText("Image size must be less then 64 KB");
                btnUpload.setDisable(true);
            }    
        }    
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pathId.setText("Select image");
        btnUpload.setDisable(true);
        
        JavaFXApplicationHWExtra.items.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change obj) {
                listId.setItems(obj.getList());
            }
        }); 
        
        listId.setMaxWidth(200);
        TableColumn<String, String> tc = new TableColumn<>("Images in DB");
        tc.setCellValueFactory((CellDataFeatures<String, String> param) -> new SimpleStringProperty(param.getValue()));
        tc.setMinWidth(198);
        listId.getColumns().add(tc);
        MySQL.getItemsFromDB();
        
        
        listId.setOnMousePressed((event) -> {
            if(event.isPrimaryButtonDown()&& event.getClickCount()==1){
               String item = listId.getSelectionModel().getSelectedItem();
               img = new Image(MySQL.getPhoto(item));
               imageView.setImage(img);
            }
        });
        
    }    
    
}
