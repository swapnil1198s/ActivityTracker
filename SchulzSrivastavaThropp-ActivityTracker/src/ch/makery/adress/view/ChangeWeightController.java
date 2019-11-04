package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;


public class ChangeWeightController {
    @FXML
    private Button button;
    
    // Reference to the main application.
    private MainApp mainApp;

    public ChangeWeightController() {
    }

    @FXML
    private void initialize() {        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
           mainApp.showChangeAgeScene(); 
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}