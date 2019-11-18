package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ch.makery.adress.MainApp;

public class StepGoalController {

	@FXML
	private Button next;
	@FXML
	private Label stepGoalText;
	@FXML
	private Button more;
	@FXML
	private Button less;
	private int stepGoal;

	// Reference to the main application.
	private MainApp mainApp;

	public StepGoalController() {
	}

	@FXML
	private void initialize() {
		stepGoalText.setText(Integer.toString(stepGoal));
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if (event.getSource() == less) {
			stepGoal = stepGoal - 100;
			stepGoalText.setText(Integer.toString(stepGoal));
		} else if (event.getSource() == more) {
			stepGoal = stepGoal + 100;
			stepGoalText.setText(Integer.toString(stepGoal));
		} else if (event.getSource() == next) {
			mainApp.getTrackerSystem().setStepGoal(stepGoal);
			mainApp.getTrackerSystem().calculateCaloriesGoal();
			mainApp.showCalorieGoalScene();
		}
	}

	public void setStepGoal(int stepGoal) {
		this.stepGoal = stepGoal;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}