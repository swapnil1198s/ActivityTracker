package ch.makery.adress.view;

	import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import ch.makery.adress.MainApp;

	public class SleepPatternController {
	    @FXML
	    private Button home;
	    @FXML
	    private Label sleepTime; 
	    @FXML 
	    private Label minsorhr; 
	    @FXML 
	    private Label sleepLevel; 
	    @FXML 
	    private Label startTime; 
	    @FXML
	    private Label endTime; 


	    // Reference to the main application.
	    private MainApp mainApp;

	    public SleepPatternController() {
	    }

	    Timeline clock;
	    @FXML
	    private void initialize() {  	
	    	clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			sleepLevel.setText(Integer.toString(mainApp.getTrackerSystem().getSleep().getLevel()));
			startTime.setText(mainApp.getTrackerSystem().getSleep().getSleepStartTime());
			endTime.setText(mainApp.getTrackerSystem().getSleep().getSleepEndeTime());
			int minsOfSleep = (int) mainApp.getTrackerSystem().getSleep().getSleepTime();
			
			if (minsOfSleep < 60 ) {
				sleepTime.setText(Integer.toString(minsOfSleep));
				minsorhr.setText("minutes");
			}
			else {
				int rest = minsOfSleep%60; 
				int hoursOfSleep = minsOfSleep / 60; 
				if (rest > 30) {
					sleepTime.setText(Integer.toString(hoursOfSleep)+".5");
				}
				else {
					sleepTime.setText(Integer.toString(hoursOfSleep));
				}
				minsorhr.setText("hours");
			}
		}), new KeyFrame(Duration.seconds(120)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	    	
	    }
	    
	    @FXML
	    private void handleButtonAction(ActionEvent event) {
	        mainApp.showHomeScene();
	    }
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;

	    }
	}
