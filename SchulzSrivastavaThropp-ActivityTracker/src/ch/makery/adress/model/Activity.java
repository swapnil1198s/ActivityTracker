package ch.makery.adress.model;

public class Activity {
	private DailySteps dailySteps;
	private DailyCalories dailyCalories; 
	private int meters;
	private double averageSpeed;
	private int caloriesBurned;
	private int stepsTaken;
	private int activityTime;

	public Activity(DailySteps dailySteps, DailyCalories dailyCalories) {
		this.dailySteps = dailySteps;
		this.dailyCalories = dailyCalories; 
		meters = 0;
		averageSpeed = 0;
		caloriesBurned = 0;
		stepsTaken = 0;
		activityTime = 0;
	}

	public void recordActivity(int mt, int steps) {
		this.meters = +mt;
		this.stepsTaken = +steps;
		this.caloriesBurned = +calculateCalories(steps);
		// meters and steps are updated every minute from the sensor
		this.activityTime = +1;
		updateAverageSpeed();
	}

	public void stopActivity() {
		dailySteps.addSteps(stepsTaken);
		dailyCalories.addCalories(caloriesBurned);
	}

	private int calculateCalories(int steps) {
		// needs work here. Here is just assumed that 1 steps burns 5 calories
		return steps * 5;
	}

	private void updateAverageSpeed() {
		averageSpeed = meters / activityTime;
	}

	public int getMeters() {
		return meters;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public int getStepsTaken() {
		return stepsTaken;
	}

	public int caloriesBurned() {
		return caloriesBurned;
	}
}
