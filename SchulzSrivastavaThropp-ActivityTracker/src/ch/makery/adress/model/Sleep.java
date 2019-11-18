package ch.makery.adress.model;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Sleep {

	private long minutes;
	private int startTime;
	private int endTime;
	private int[] heartrate = { 0 };

	Instant start;
	SimpleDateFormat formatter = new SimpleDateFormat("HH");

	// for testing purposes
	// SimpleDateFormat formatter = new SimpleDateFormat("ss");

	public Sleep(Date startDate, Date endDate) {
		startTime = Integer.parseInt(formatter.format(startDate));
		endTime = Integer.parseInt(formatter.format(endDate));
	}

	public Sleep() {
		Date date = new Date();

		startTime = Integer.parseInt(formatter.format(date));
		start = Instant.now();
		heartrate = new int[0];
	}

	public void startSleepForTesting() {
		Date date = new Date();

		startTime = Integer.parseInt(formatter.format(date));
		start = Instant.now();
		heartrate = new int[0];
	}

	public void endSleep() {
		Date date = new Date();
		endTime = Integer.parseInt(formatter.format(date));

		Instant finish = Instant.now();
		minutes = Duration.between(start, finish).toMinutes();

		// for test cases
		// minutes = Duration.between(start, finish).toSeconds();
		// minutes = minutes * 60;
	}

	public long getSleepTime() {
		return minutes;
	}

	public String getSleepStartTime() {
		if (startTime < 13) {
			return Integer.toString(startTime) + " am";
		} else {
			return Integer.toString(startTime - 12) + " pm";
		}
	}

	public String getSleepEndeTime() {
		if (endTime < 13) {
			return Integer.toString(endTime) + " am";
		} else {
			return Integer.toString(endTime - 12) + " pm";
		}
	}

	public int getLevel() {

		int sum = 0;
		for (int i = 0; i < heartrate.length; i++) {
			sum += heartrate[i];
		}
		int averageHR;
		if (minutes < 5) {
			averageHR = sum;
		} else {
			averageHR = (int) (sum / (minutes / 5));

			// for test cases
			// averageHR = sum;
		}

		// needs work: follow: https://ouraring.com/heart-rate-while-sleeping/
		// level 5 sleep with more than 8 hours and an average heart rate is between 50
		// and 60

		// System.out.println("minutes: " + minutes);
		// System.out.println("avg hr: " + averageHR);

		if (minutes >= 480 && averageHR > 50 && averageHR < 60) {
			return 5;
		} else if (minutes > 420 && averageHR > 50 && averageHR < 60) {
			return 4;
		} else if (minutes > 390 && averageHR > 50 && averageHR < 80) {
			return 3;
		} else if (minutes > 300 && averageHR < 100) {
			return 2;
		}
		return 1;
	}

	public void recordSleep(int sensorfeedback) {
		int[] heartrate2 = new int[heartrate.length + 1];
		for (int i = 0; i < heartrate.length; i++) {
			heartrate2[i] = heartrate[i];
		}
		heartrate2[heartrate.length] = sensorfeedback;
		heartrate = heartrate2;
	}

}
