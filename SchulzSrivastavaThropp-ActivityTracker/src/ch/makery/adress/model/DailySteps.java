package ch.makery.adress.model;

public class DailySteps {
	private int dailySteps;

	public DailySteps() {
		dailySteps = 0;
	}

	public void setSteps(int amount) {
		dailySteps = amount;
	}

	public void subtractSteps(int amount) {
		dailySteps -= amount;
	}

	public void addSteps(int amount) {
		dailySteps += amount;
	}

	public int getDailySteps() {
		return dailySteps;
	}
}
