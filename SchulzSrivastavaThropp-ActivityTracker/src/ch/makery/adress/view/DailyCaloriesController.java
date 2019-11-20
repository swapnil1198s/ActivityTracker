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

public class DailyCaloriesController {
	@FXML
	private Button steps;
	@FXML
	private Button settings;
	@FXML
	private Label calories;
	@FXML
	private ProgressBar progress;

	// Reference to the main application.
	private MainApp mainApp;

	public DailyCaloriesController() {
	}

	Timeline clock;

	@FXML
	private void initialize() {
		clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			calories.setText(Integer.toString(mainApp.getTrackerSystem().getDailyCalories()));
			progress.setProgress((mainApp.getTrackerSystem().getDailyCalories()/mainApp.getTrackerSystem().getCaloriesGoal())*100); 
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if (event.getSource() == steps) {
			mainApp.showDailyStepScene();
			clock.stop();
		} else if (event.getSource() == settings)
			mainApp.showChangeWeightScene();
		clock.stop();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}