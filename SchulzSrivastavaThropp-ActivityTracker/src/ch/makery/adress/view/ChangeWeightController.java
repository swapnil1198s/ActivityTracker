package ch.makery.adress.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ch.makery.adress.MainApp;

public class ChangeWeightController {
	@FXML
	private Button button;
	@FXML
	private Label weightText;
	@FXML
	private Button less;
	@FXML
	private Button more;
	private int weight;

	// Reference to the main application.
	private MainApp mainApp;

	public ChangeWeightController() {
	}

	@FXML
	private void initialize() {
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if (event.getSource() == less) {
			weight--;
			weightText.setText(Integer.toString(weight));
		} else if (event.getSource() == more) {
			weight++;
			weightText.setText(Integer.toString(weight));
		} else if (event.getSource() == button) {
			mainApp.getTrackerSystem().setWeight(weight);
			mainApp.showChangeAgeScene();
		}

		// mainApp.showCalorieGoalScene();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	public void setWeight(int weight) {
		this.weight = weight;
		weightText.setText(Integer.toString(weight));
	}
}