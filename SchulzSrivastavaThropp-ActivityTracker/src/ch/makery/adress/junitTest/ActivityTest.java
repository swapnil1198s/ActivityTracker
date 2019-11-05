package ch.makery.adress.junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.makery.adress.model.Activity;
import ch.makery.adress.model.DailyCalories;
import ch.makery.adress.model.DailySteps;

public class ActivityTest {
	DailyCalories testDailyCal = new DailyCalories(); 
	DailySteps testDailySteps = new DailySteps(); 
	Activity sut = new Activity(testDailySteps, testDailyCal);
	
	@Test
	public void testRecordActivity() {
		//given 
		sut.recordActivity(30, 40); 
		// when 
		String actual = Integer.toString(sut.getAverageSpeed()) + Integer.toString(sut.getCaloriesBurned()) +Integer.toString(sut.getMeters())+Integer.toString(sut.getStepsTaken());
		String expected = "30"+"200"+ "30"+"40"; 
		//then 
		assertEquals (actual, expected);
	}
	
	// test, test
	@Test
	public void testRecordActivityWithMultipleRecords() {
		//given 
		sut.recordActivity(30, 40); 
		sut.recordActivity(20, 50);
		sut.recordActivity(5, 15);
		// when 
		String actual = Integer.toString(sut.getAverageSpeed()) + Integer.toString(sut.getCaloriesBurned()) +Integer.toString(sut.getMeters())+Integer.toString(sut.getStepsTaken());
		String expected = "18"+"525"+ "55"+"105"; 
		//then 
		assertEquals (actual, expected);
	}
	
	@Test
	public void testStopActivity () {
		//given
		sut.recordActivity(30, 40); 
		sut.stopActivity();
		//when 
		String actual = Integer.toString(testDailyCal.getDailyCalories()) + Integer.toString(testDailySteps.getDailySteps()); 
		String expected = "200"+"40"; 
		//then 
		assertEquals (actual, expected);
	}
	
	

}
