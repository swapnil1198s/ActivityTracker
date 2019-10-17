package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;


public class DailyStepController {
    @FXML
    private Button sleep;

    // Reference to the main application.
    private MainApp mainApp;

    public DailyStepController() {
    }

    @FXML
    private void initialize() { 
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        mainApp.showSleepScene();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}