package ch.makery.adress;

import java.io.IOException;

import ch.makery.adress.view.CaloriesBurnedController;
import ch.makery.adress.view.ChangeAgeController;
import ch.makery.adress.view.ChangeDateController;
import ch.makery.adress.view.ChangeTimeController;
import ch.makery.adress.view.ChangeWeightController;
import ch.makery.adress.view.DailyStepController;
import ch.makery.adress.view.HomeController;
import ch.makery.adress.view.SleepController;
import ch.makery.adress.view.StepGoalController;
import ch.makery.adress.model.DailySteps;
import ch.makery.adress.view.CalorieGoalController;
import ch.makery.adress.view.SettingsListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    //private DailySteps dailySteps; 
 
    
    public MainApp() {

    }
  
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        //dailySteps = new DailySteps(); 
        initRootLayout();

        showHomeScene();
    }
    
    public void initRootLayout() {
        try {
        	
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
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
    public void showCaloriesBurnedScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/caloriesBurned.fxml"));
            Pane showCaloriesBurned = (Pane) loader.load();
            
            rootLayout.setCenter(showCaloriesBurned);

            // Give the controller access to the main app.
           CaloriesBurnedController controller = loader.getController();
           controller.setMainApp(this);
 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSetStepGoalScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/stepgoal.fxml"));
            Pane showSetStepGoalScene = (Pane) loader.load();

            rootLayout.setCenter(showSetStepGoalScene);

            // Give the controller access to the main app.
            StepGoalController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDailyStepScene() {
        try {
        	 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/totalSteps.fxml"));
            Pane showDailyStepScene = (Pane) loader.load();
            
            rootLayout.setCenter(showDailyStepScene);

            // Give the controller access to the main app.
           DailyStepController controller = loader.getController();
           controller.setMainApp(this);
           //controller.setDailySteps (dailySteps);
 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSleepScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/sleep.fxml"));
            Pane showCaloriesBurned = (Pane) loader.load();
            
            rootLayout.setCenter(showCaloriesBurned);

            // Give the controller access to the main app.
           SleepController controller = loader.getController();
           controller.setMainApp(this);
 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showChangeDateScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/changeDate.fxml"));
            Pane showCaloriesBurned = (Pane) loader.load();
            
            rootLayout.setCenter(showCaloriesBurned);

            // Give the controller access to the main app.
           ChangeDateController controller = loader.getController();
           controller.setMainApp(this);
 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showChangeTimeScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/changeTime.fxml"));
            Pane showCaloriesBurned = (Pane) loader.load();
            
            rootLayout.setCenter(showCaloriesBurned);

            // Give the controller access to the main app.
           ChangeTimeController controller = loader.getController();
           controller.setMainApp(this);
 

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
 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showChangeAgeScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ageSetting.fxml"));
            Pane showCaloriesBurned = (Pane) loader.load();
            
            rootLayout.setCenter(showCaloriesBurned);

            // Give the controller access to the main app.
           ChangeAgeController controller = loader.getController();
           controller.setMainApp(this);
 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showCalorieGoalScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/calorieGoal.fxml"));
            Pane showCalorieGoalScene = (Pane) loader.load();

            rootLayout.setCenter(showCalorieGoalScene);

            // Give the controller access to the main app.
            CalorieGoalController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void showSettingsList() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/settings.fxml"));
            Pane showSettingsList = (Pane) loader.load();

            rootLayout.setCenter(showSettingsList);

            // Give the controller access to the main app.
            SettingsListController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}