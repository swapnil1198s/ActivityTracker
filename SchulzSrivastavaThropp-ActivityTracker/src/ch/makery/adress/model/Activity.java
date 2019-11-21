package ch.makery.adress.model;

public class Activity {
	private DailySteps dailySteps;
	private DailyCalories dailyCalories;
	private int meters;
	private int averageSpeed;
	private int caloriesBurned;
	private int stepsTaken;
	private int activityTime;
	private int lastHeartRate;
	// private TrackerSystem trackerSystem;

	public Activity(DailySteps dailySteps, DailyCalories dailyCalories) {
		this.dailySteps = dailySteps;
		this.dailyCalories = dailyCalories;
		meters = 0;
		averageSpeed = 0;
		caloriesBurned = 0;
		stepsTaken = 0;
		activityTime = 0;
		// this.trackerSystem = trackerSystem;
	}

	public void recordActivity(int heartRate, int mt, int steps) {
		this.meters += mt;
		this.stepsTaken += steps;
		this.caloriesBurned += calculateCalories(steps);
		// meters and steps are updated every minute from the sensor
		this.activityTime += 1;
		this.lastHeartRate = heartRate;
		updateAverageSpeed();
	}

	public void stopActivity() {
		dailySteps.addSteps(stepsTaken);
		dailyCalories.addCalories(caloriesBurned);
	}

	private int calculateCalories(int steps) {
		// Here is just assumed that 1 steps burns 0,25 calorie
		return (int) (steps * 0.25);
	}

	private void updateAverageSpeed() {
		averageSpeed = meters / activityTime;
	}

	public int getMeters() {
		return meters;
	}

	public void setMeters(int amount) {
		meters = amount;
	}

	public int getAverageSpeed() {
		return averageSpeed;
	}

	public int getSteps() {
		return stepsTaken;
	}

	public void setSteps(int amount) {
		stepsTaken = amount;
	}

	public int getCaloriesBurned() {
		return caloriesBurned;
	}

	public int getHeartRate() {
		return lastHeartRate;
	}
}
