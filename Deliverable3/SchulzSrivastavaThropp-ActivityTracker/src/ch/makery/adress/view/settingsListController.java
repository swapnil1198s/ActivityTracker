package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;


public class settingsListController {
    @FXML
    private Button settings;


    // Reference to the main application.
    private MainApp mainApp;

    public settingsListController() {
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        mainApp.showHomeScene();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}