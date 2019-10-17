package ch.makery.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    	mainWindow();
    }
    
    public void mainWindow() {
    	try {
    	FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/home.fxml"));
    	
			AnchorPane pane = loader.load();
		
    	
    	MainWindowController mainWindowController = loader.getController();
    	
    	Scene scene = new Scene(pane);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main(String args) {
    	launch(args);
    }
}