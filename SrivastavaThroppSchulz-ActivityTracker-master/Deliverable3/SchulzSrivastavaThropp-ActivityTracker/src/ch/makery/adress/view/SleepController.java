package ch.makery.adress.view;

	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import ch.makery.adress.MainApp;

	public class SleepController {
	    @FXML
	    private Button home;


	    // Reference to the main application.
	    private MainApp mainApp;

	    public SleepController() {
	    }

	    @FXML
	    private void initialize() {   
	    }
	    
	    @FXML
	    private void handleButtonAction(ActionEvent event) {
	        mainApp.showHomeScene();;
	    }
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;

	    }
	}
