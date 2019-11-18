package ch.makery.adress.view;

import ch.makery.adress.MainApp;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ActivitySceneController {
	@FXML
	private Button next;
	@FXML
	private Button endActivity;
	@FXML
	private Label meters;
	@FXML
	private Label heartrate;
	@FXML
	private Label caloriesBurned;

	// Reference to the main application.
	private MainApp mainApp;

	public ActivitySceneController() {
	}

	Timeline clock;

	@FXML
	private void initialize() {
		clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			meters.setText(Integer.toString(mainApp.getTrackerSystem().getCurrentActivity().getMeters()));
			caloriesBurned
					.setText(Integer.toString(mainApp.getTrackerSystem().getCurrentActivity().getCaloriesBurned()));
			heartrate.setText(Integer.toString(mainApp.getTrackerSystem().getCurrentActivity().getHeartRate()));
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {

		if (event.getSource() == next)
			mainApp.showHomeScene();
		else if (event.getSource() == endActivity) {
			this.mainApp.getTrackerSystem().endActivity();
			clock.stop();
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
