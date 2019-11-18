package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ch.makery.adress.MainApp;

public class ChangeAgeController {
	@FXML
	private Button home;
	@FXML
	private Button male;
	@FXML
	private Button female;
	@FXML
	private Label ageText;
	@FXML
	private Button less;
	@FXML
	private Button more;
	private int age;

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
			age--;
			ageText.setText(Integer.toString(age));
		} else if (event.getSource() == more) {
			age++; 
			ageText.setText(Integer.toString(age));
		} else if (event.getSource() == male) {
			mainApp.getTrackerSystem().setGender(false);
		} else if (event.getSource() == female) {
			mainApp.getTrackerSystem().setGender(true);
		}

		else if (event.getSource() == home) {
			mainApp.getTrackerSystem().setAge(age);
			mainApp.getTrackerSystem().calculateCaloriesGoal();
			mainApp.showSetStepGoalScene();
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	public void setAge(int age) {
		this.age = age;
		ageText.setText(Integer.toString(age));
	}
}