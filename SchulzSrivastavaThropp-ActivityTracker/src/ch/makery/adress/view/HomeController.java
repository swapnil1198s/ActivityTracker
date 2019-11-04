package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;


public class HomeController {
    @FXML
    private Button calories;
    @FXML
    private Button settings; 


    // Reference to the main application.
    private MainApp mainApp;

    public HomeController() {
    }

    @FXML
    private void initialize() {
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if (event.getSource() == calories)
           mainApp.showCaloriesBurnedScene(); 
        else if(event.getSource() == settings)
           mainApp.showChangeDateScene();
        //mainApp.showSettingsList();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}