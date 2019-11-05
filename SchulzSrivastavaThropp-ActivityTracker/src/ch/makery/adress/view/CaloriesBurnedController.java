package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;

public class CaloriesBurnedController {
    @FXML
    private Button steps;
    @FXML
    private Button settings;
    


    // Reference to the main application.
    private MainApp mainApp;

    public CaloriesBurnedController() {
    }

    @FXML
    private void initialize() {
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == steps)
            mainApp.showDailyStepScene();
         else if(event.getSource() == settings)
            mainApp.showChangeWeightScene(); 
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}