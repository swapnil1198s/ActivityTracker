package ch.makery.adress.view;

import ch.makery.adress.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class calorieGoalController {

    @FXML
    private Button next;

    // Reference to the main application.
    private MainApp mainApp;

    public calorieGoalController() {
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == next)
            mainApp.showCaloriesBurnedScene();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}
