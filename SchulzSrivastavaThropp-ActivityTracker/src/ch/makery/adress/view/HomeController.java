package ch.makery.adress.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import ch.makery.adress.MainApp;

public class HomeController {
	@FXML
	private Button calories;
	@FXML
	private Button settings;
	@FXML
	private Button startActivity;
	@FXML
	private Label minute;
	@FXML
	private Label hour;
	@FXML
	private Label dateFXML;

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
		// maybe add am or pm
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			LocalTime currentTime = LocalTime.now();
			hh = currentTime.getHour();
			if (hh < 10) {
				hhString = "0" + Integer.toString(hh);
			} else {
				hhString = Integer.toString(hh);
			}
			hour.setText(hhString + ":");

			min = currentTime.getMinute();
			if (min < 10) {
				minString = "0" + Integer.toString(min);
			} else {
				minString = Integer.toString(min) + " ";
			}
			minute.setText(minString);

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
			// get current date time with Date()
			Date date = new Date();
			dateFXML.setText(dateFormat.format(date));
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();

	}

	@FXML
	private void handleButtonAction(ActionEvent event) {

		if (event.getSource() == calories)
			mainApp.showCaloriesBurnedScene();
		else if (event.getSource() == settings) {
			// mainApp.showChangeDateScene();
			// mainApp.showSettingsList();
			mainApp.getTrackerSystem().startSleep();
			mainApp.showSleepScene();
		} else if (event.getSource() == startActivity) {
			mainApp.getTrackerSystem().startActivity();
			mainApp.showActivityScene();
		}

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}