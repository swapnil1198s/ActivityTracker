package ch.makery.adress.model;

public class DailySteps {
 private int dailySteps ; 
 
 public DailySteps () {
	 dailySteps = 0; 
 }
 
 public void addSteps (int amount) {
	 dailySteps += amount; 
 }
 
 public int getDailySteps() {
	 return dailySteps; 
 }
}
