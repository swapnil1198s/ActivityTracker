package ch.makery.adress.model;

public class DailyCalories {
	private int dailyCalories;

	public DailyCalories() {
		dailyCalories = 0;
	}

	public void setCalories(int amount) {
		dailyCalories = amount;
	}

	public void addCalories(int amount) {
		dailyCalories += amount;
	}

	public void subtractCalories(int amount) {
		dailyCalories -= amount;
	}

	public int getDailyCalories() {
		return dailyCalories;
	}
}
