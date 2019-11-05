package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ch.makery.adress.MainApp;
import ch.makery.adress.model.DailySteps;


public class DailyStepController {
    @FXML
    private Button sleep;
    @FXML
    private Button settings;
    @FXML
    private Label steps; 

    private DailySteps model; 
    // Reference to the main application.
    private MainApp mainApp;

    public DailyStepController() {
    }

    @FXML
    private void initialize() { 
    	steps.setText(Integer.toString(model.getDailySteps()));
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == settings)
            mainApp.showSetStepGoalScene();
            else
                mainApp.showSleepScene();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}