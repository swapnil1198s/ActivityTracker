package ch.makery.adress.view;

import ch.makery.adress.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SleepController {
	@FXML
	private Button sleepPattern;
	@FXML
	private Button button;

	// Reference to the main application.
	private MainApp mainApp;

	public SleepController() {

	}

	@FXML
	private void initialize() {
		/*
		 * Image image = new Image(getClass().getResourceAsStream("a.png")); Button
		 * button1 = new Button("Accept"); button1.setGraphic(new ImageView(image));
		 */
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		mainApp.getTrackerSystem().endSleep();
		mainApp.showSleepPatternScene();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}
