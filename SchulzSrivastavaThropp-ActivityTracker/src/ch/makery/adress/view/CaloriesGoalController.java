package ch.makery.adress.view;

import ch.makery.adress.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CaloriesGoalController {

	@FXML
	private Button next;
	@FXML
	private Label caloriesGoalText;
	@FXML
	private Button more;
	@FXML
	private Button less;
	private int caloriesGoal;

	// Reference to the main application.
	private MainApp mainApp;

	public CaloriesGoalController() {
	}

	@FXML
	private void initialize() {
		caloriesGoalText.setText(Integer.toString(caloriesGoal));
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if (event.getSource() == less) {
			caloriesGoal = caloriesGoal - 100;
			caloriesGoalText.setText(Integer.toString(caloriesGoal));
		} else if (event.getSource() == more) {
			caloriesGoal = caloriesGoal + 100;
			caloriesGoalText.setText(Integer.toString(caloriesGoal));
		} else if (event.getSource() == next) {
			mainApp.getTrackerSystem().setCaloriesGoal(caloriesGoal);
			mainApp.showHomeScene();
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	public void setCaloriesGoal(int caloriesGoal) {
		this.caloriesGoal = caloriesGoal;
	}
}
