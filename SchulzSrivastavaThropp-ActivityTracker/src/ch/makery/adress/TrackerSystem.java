package ch.makery.adress;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ch.makery.adress.model.Activity;
import ch.makery.adress.model.DailyCalories;
import ch.makery.adress.model.DailySteps;
import ch.makery.adress.model.Sensor;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TrackerSystem {
	// The system is able to store the DailySteps an the Daily Calories of the last 10 days
	private DailyCalories saveDailyCalories []  = new DailyCalories [10];  
	private DailySteps saveDailySteps [] = new DailySteps [10];
	//.. and the last 30 activities
	private Activity saveActivities [] = new Activity [30];
	
	// current DailySteps and DailyCalories
	private DailyCalories currentDailyCalories; 
	private DailySteps currentDailySteps;
	private Activity currentActivity; 
	private Sensor sensor; 
	
	private int age; 
	private int weight; // in lbs
	private Date currentDate; 
	
	Calendar cal1;
	Calendar cal2; 
	
	public TrackerSystem () {
		// set a default age and weight. Maybe change it that after the first start of the activityTracker has to inser his age and weight
		age= 40; 
		weight = 150; 
		
		sensor= new Sensor(); 
		setUpDailySteps(); 
		setUpDailyCalories();
		setUpActivities(); 
		
		currentDate = new Date(); 
		cal1 =Calendar.getInstance();
		cal1.setTime(currentDate); 
		checkDate(); 
	}
	
	ScheduledExecutorService service;
	public void startActivity () {
		currentActivity = new Activity(currentDailySteps, currentDailyCalories);
		 
		 Runnable runnable = new Runnable() {	      
			 public void run() {	        	        
				 		int sensorfeedback [] = sensor.meassureActivity(); 
				   	 	currentActivity.recordActivity(sensorfeedback[0],sensorfeedback[1], sensorfeedback[2]);
				   	}	    	      	    
			 };	    	    
			 service = Executors.newSingleThreadScheduledExecutor();
			 service.scheduleAtFixedRate(runnable, 0, 30, TimeUnit.SECONDS);	  
	}
	
	public void endActivity() {
		// end the loop for getting data from the sensor
		service.shutdown();
		// update DailySteps and DailyCalories
		currentDailySteps.addSteps(currentActivity.getSteps()); 
		currentDailyCalories.addCalories(currentActivity.getCaloriesBurned());
		// save activity in front of our "Database"
		for (int i = saveActivities.length -1; i>= 1 ; i--) {
			saveActivities[i]= saveActivities[i-1]; 
		}
	}
		

	// every new Day this method stores the old DailyStep and DailyCaloriesObject and create a new One for the current day
	private void checkDate() {
    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> { 
    	// set the current Date
    	cal2 =Calendar.getInstance(); 
    	Date date2 = new Date (); 
    	cal2.setTime(date2);
    	
    	//check if it is a new Day
    	if(cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) != cal2.get(Calendar.DAY_OF_YEAR)) {
    		// move all the current saved Daily Calories one spot behind ( the last will be overwritten)
    		for (int i = saveDailyCalories.length -1; i>= 1 ; i--) {
    			saveDailyCalories[i]= saveDailyCalories[i-1]; 
    		}
    		// save the current one as the first element 
    		saveDailyCalories[0] = currentDailyCalories; 
    		//create a new DailyCalories for the new day
    		currentDailyCalories = new DailyCalories(); 
    		
    		// same thing for DailySteps
    		for (int i = saveDailySteps.length -1; i>= 1 ; i--) {
    			saveDailySteps[i]= saveDailySteps[i-1]; 
    		}
    		saveDailySteps[0] = currentDailySteps; 
    		currentDailySteps = new DailySteps();
    		
    	}
    }),
         new KeyFrame(Duration.seconds(180))
    );
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();

	}
	
	// help methods: 
	private void setUpDailyCalories() {
		currentDailyCalories = new DailyCalories();
		// fill saveDailyCalories with empty data
		for ( int i = 0; i< saveDailyCalories.length  ; i++) {
			saveDailyCalories[i]= new DailyCalories(); 
		}
	}

	private void setUpDailySteps() {
		currentDailySteps = new DailySteps(); 
		// fill saveDailySteps with empty data
		for ( int i = 0; i< saveDailySteps.length ; i++) {
			saveDailySteps[i]= new DailySteps(); 
		}
	}
	
	private void setUpActivities() {
		// fill saveDailySteps with empty data
		for ( int i = 0; i< saveActivities.length ; i++) {
			saveActivities[i]= new Activity(null, null); 
		}
	}
	// getter and setter methods
	public int getAge() {
		return age; 
	}
	public int getWeight() {
		return weight ;
	}
	public void setAge(int age) {
		this.age = age; 
	}
	public void setWeight ( int weight) {
		this.weight = weight; 
	}
	public Activity getCurrentActivity() {
		return currentActivity; 
	}
	public int getDailyCalories() {
		return currentDailyCalories.getDailyCalories();
	}
	public int getDailySteps () {
		return currentDailySteps.getDailySteps(); 
	}

}
