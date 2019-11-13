package ch.makery.adress.model;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Sleep {
	
	private long minutes;
	private Date startTime; 
	private Date endTime;
	private int[] heartrate; 
	
	Instant start;
	
	public Sleep () {
		//startTime= new Date(); 
		 start = Instant.now();
		 heartrate = new int [0]; 
		 
	}
	
	public void endSleep () {
		endTime = new Date(); 
		//hours = endTime.getHours() - startTime.getHours(); 
		Instant finish = Instant.now();
		minutes = Duration.between(start, finish).toMinutes();
	}
	
	public long getSleepTime (){
		return minutes; 
	}
	public Date getSleepStartTime (){
		return startTime; 
	}
	public Date getSleepEndeTime (){
		return endTime; 
	}
	public int getLevel () {
		int sum = 0; 
		for (int i =0; i< heartrate.length; i++) {
	            sum += heartrate[i]; 
	        }
		int averageHR ; 
		if ( minutes < 5) {
			averageHR = sum; 
		}
		else {
		 averageHR = (int) (sum/(minutes/5)); 
		}
		
		// needs work: follow: https://ouraring.com/heart-rate-while-sleeping/
		// level 5 sleep with more than 8 hours and an average heart rate is between 50 and 60
		
		if (minutes > 480 && averageHR > 50 && averageHR <60) {
			return 5; 
	    }
		if (minutes > 420 && averageHR > 50 && averageHR <60){
			return 4; 
		}
		if (minutes > 390 && averageHR > 50 && averageHR <80){
			return 3; 
		}
		if (minutes > 300 && averageHR <100) {
			return 2; 
		}
		return 1; 
	}

	
	// For testing reasons
	public void setStartTime (Date startTime) {
		this.startTime = startTime; 
	}
	public void setEndeTime (Date endTime) {
		this.endTime = endTime; 
	}

	public void recordSleep(int sensorfeedback) {
		int [] heartrate2  = new int [heartrate.length +1]; 
		 for (int i = 0; i<heartrate.length; i++) {
			 heartrate2 [i] = heartrate[i]; 
		 }
		 heartrate2 [heartrate.length]= sensorfeedback; 
		 heartrate = heartrate2; 
	}

}
