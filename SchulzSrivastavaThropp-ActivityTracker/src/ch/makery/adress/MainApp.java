package ch.makery.adress;

import java.io.IOException;

import ch.makery.adress.view.DailyCaloriesController;
import ch.makery.adress.view.ChangeAgeController;
import ch.makery.adress.view.ChangeWeightController;
import ch.makery.adress.view.DailyStepController;
import ch.makery.adress.view.HomeController;
import ch.makery.adress.view.SleepPatternController;
import ch.makery.adress.view.StepGoalController;
import ch.makery.adress.view.ActivitySceneController;
import ch.makery.adress.view.CaloriesGoalController;
import ch.makery.adress.view.SleepController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private TrackerSystem trackerSystem;

	public MainApp() {

	}

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.trackerSystem = new TrackerSystem();
		initRootLayout();

		showChangeWeightScene();
	}

	public void initRootLayout() {
		try {

			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/rootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showActivityScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/activity.fxml"));
			Pane showActivity = (Pane) loader.load();

			rootLayout.setCenter(showActivity);

			// Give the controller access to the main app.
			ActivitySceneController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showCalorieGoalScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/caloriesGoal.fxml"));
			Pane showCalorieGoalScene = (Pane) loader.load();

			rootLayout.setCenter(showCalorieGoalScene);

			// Give the controller access to the main app.
			CaloriesGoalController controller = loader.getController();
			controller.setCaloriesGoal (trackerSystem.getCaloriesGoal());
			controller.setMainApp(this);
			 

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showChangeAgeScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ageSetting.fxml"));
			Pane showChangeAge = (Pane) loader.load();

			rootLayout.setCenter(showChangeAge);

			// Give the controller access to the main app.
			ChangeAgeController controller = loader.getController();
			controller.setMainApp(this);
			controller.setAge(trackerSystem.getAge());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showChangeWeightScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/weightSetting.fxml"));
			Pane showCaloriesBurned = (Pane) loader.load();

			rootLayout.setCenter(showCaloriesBurned);

			// Give the controller access to the main app.
			ChangeWeightController controller = loader.getController();
			controller.setMainApp(this);
			controller.setWeight(trackerSystem.getWeight());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showDailyStepScene() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/dailySteps.fxml"));
			Pane showDailyStepScene = (Pane) loader.load();

			rootLayout.setCenter(showDailyStepScene);

			// Give the controller access to the main app.
			DailyStepController controller = loader.getController();
			controller.setMainApp(this);
			// controller.setDailySteps (dailySteps);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showDailyCaloriesScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/dailyCalories.fxml"));
			Pane showCaloriesBurned = (Pane) loader.load();

			rootLayout.setCenter(showCaloriesBurned);

			// Give the controller access to the main app.
			DailyCaloriesController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHomeScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/home.fxml"));
			Pane startScene = (Pane) loader.load();

			rootLayout.setCenter(startScene);

			// Give the controller access to the main app.
			HomeController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showSleepScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/sleep.fxml"));
			Pane showSleep = (Pane) loader.load();

			rootLayout.setCenter(showSleep);

			// Give the controller access to the main app.
			SleepController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showSleepPatternScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/sleepPattern.fxml"));
			Pane showSleepPatern = (Pane) loader.load();

			rootLayout.setCenter(showSleepPatern);

			// Give the controller access to the main app.
			SleepPatternController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showSetStepGoalScene() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/stepGoal.fxml"));
			Pane showSetStepGoalScene = (Pane) loader.load();

			rootLayout.setCenter(showSetStepGoalScene);

			// Give the controller access to the main app.
			StepGoalController controller = loader.getController();
			controller.setMainApp(this);
			trackerSystem.calculateStepGoal(); 
			controller.setStepGoal(trackerSystem.getStepGoal());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public TrackerSystem getTrackerSystem() {
		return trackerSystem;
	}

	public static void main(String[] args) {
		launch(args);
	}

}