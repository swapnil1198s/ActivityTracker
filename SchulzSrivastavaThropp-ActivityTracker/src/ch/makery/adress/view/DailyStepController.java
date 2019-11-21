package ch.makery.adress.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import ch.makery.adress.MainApp;

public class DailyStepController {
	@FXML
	private Button sleep;
	@FXML
	private Button settings;
	@FXML
	private Label steps;
	
	@FXML 
	private ProgressBar progress; 
	// Reference to the main application.
	private MainApp mainApp;

	public DailyStepController() {

	}

	Timeline clock;

	@FXML
	private void initialize() {
		clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			double dS = mainApp.getTrackerSystem().getDailySteps();
			double sG = mainApp.getTrackerSystem().getStepGoal();
			steps.setText(Integer.toString((int)dS));
			progress.setProgress(dS/sG);
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if (event.getSource() == settings) {
			mainApp.showSetStepGoalScene();
			clock.stop();
		} else
			mainApp.showSleepPatternScene();
		clock.stop();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}