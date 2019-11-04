package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;

public class stepgoalController {

    @FXML
    private Button next;

    // Reference to the main application.
    private MainApp mainApp;

    public stepgoalController() {
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == next)
            mainApp.showDailyStepScene();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}