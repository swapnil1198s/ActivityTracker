package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ch.makery.adress.MainApp;


public class HomeController {
    @FXML
    private Button calories;
    @FXML
    private Button settings;
    @FXML
    private Label minute; 
    @FXML
    private Label hour;

    private int hh;
    private String hhString;
    private int min;
    private String minString; 
 
    // Reference to the main application.
    private MainApp mainApp;

    public HomeController() {
    }

    @FXML
    private void initialize() {
    	 Thread clock = new Thread() {
    	        public void run() {
    	            for (;;) {
    	                Calendar cal = Calendar.getInstance();
    	                hh =cal.get(Calendar.HOUR);
    	                if ( hh <10) {
    	                	hhString = "0" + Integer.toString(hh);
    	                }
    	                else {
    	                	hhString= Integer.toString(hh);
    	                }
    	                minute.setText(hhString+ ":"); 
    	                
    	                min = cal.get(Calendar.MINUTE);
    	                if (min <10) {
    	                	minString = "0" + Integer.toString(min); 
    	                }
    	                else {
    	                	minString = Integer.toString(min); 
    	                }
    	                hour.setText(minString);
    	                //System.out.println(hour + ":" + (minute) + ":" + second);
    	            }
    	        }
    	    };
    	    clock.start();
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