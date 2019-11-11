package ch.makery.adress.model;

public class DailyCalories {
 private int dailyCalories; 
 
 public DailyCalories () {
	 dailyCalories=0; 
 }
 
 public void addCalories(int amount) {
	 dailyCalories += amount; 
 }
 
 public int getDailyCalories () {
	 return dailyCalories; 
 }
}
