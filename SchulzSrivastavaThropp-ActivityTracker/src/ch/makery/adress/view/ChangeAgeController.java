package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;


public class ChangeAgeController {
    @FXML
    private Button button;
    
    // Reference to the main application.
    private MainApp mainApp;
package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ch.makery.adress.MainApp;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class ChangeAgeController {
    @FXML
    private Button home;
    @FXML
    private Text age;
    @FXML
    private Button less;
    @FXML
    private Button more;
    
    // Reference to the main application.
    private MainApp mainApp;

    public ChangeAgeController() {
    }

    @FXML
    private void initialize() {
    	
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    	if (event.getSource() == less) {
    		int current = Integer.parseInt(age.getText());
    		int newAge = current-1; 
    		String nAge = Integer.toString(newAge);
            age.setText(nAge); 
    		}
         else if(event.getSource() == more) {
        	int current = Integer.parseInt(age.getText());
			int newAge = current+1; 
			String nAge = Integer.toString(newAge);
			age.setText(nAge); 
			}
         else if(event.getSource() == home){
        	 mainApp.showHomeScene();
         }
    	
        //mainApp.showCalorieGoalScene();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}