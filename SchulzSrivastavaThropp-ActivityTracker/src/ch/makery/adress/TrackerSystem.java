package ch.makery.adress;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ch.makery.adress.model.Activity;
import ch.makery.adress.model.DailyCalories;
import ch.makery.adress.model.DailySteps;
import ch.makery.adress.model.Sensor;
import ch.makery.adress.model.Sleep;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TrackerSystem {
	// The system is able to store the Sleep, DailySteps an the Daily Calories of
	// the last 10 days
	private DailyCalories saveDailyCalories[] = new DailyCalories[10];
	private DailySteps saveDailySteps[] = new DailySteps[10];
	private Sleep saveSleeps[] = new Sleep[10];
	// .. and the last 30 activities
	private Activity saveActivities[] = new Activity[30];

	// current DailySteps and DailyCalories
	private DailyCalories currentDailyCalories;
	private DailySteps currentDailySteps;
	private Activity currentActivity;
	private Sensor sensor;
	private Sleep sleep;

	private boolean genderFemale;
	private int age;
	private int weight; // in lbs
	private int stepGoal;
	private int caloriesGoal;
	private Date currentDate;

	Calendar cal1;
	Calendar cal2;

	ScheduledExecutorService service;

	public TrackerSystem() {
		// set a default age and weight. Maybe change it that after the first start of
		// the activityTracker has to inser his age and weight
		age = 40;
		weight = 150;
		genderFemale = true;

		sensor = new Sensor();
		setUpDailySteps();
		setUpDailyCalories();
		setUpActivities();
		setUpSleep();

		currentDate = new Date();
		cal1 = Calendar.getInstance();
		cal1.setTime(currentDate);
		checkDate();
		startCheckMeters();
	}

	public void startCheckMeters() {
		Runnable runnable = new Runnable() {
			public void run() {
				int sensorfeedback = sensor.meassureMeters();
				currentDailySteps.addSteps(sensorfeedback);
				currentDailyCalories.addCalories(sensorfeedback * 5);
			}
		};
		service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 0, 30, TimeUnit.SECONDS);
	}

	public void startActivity() {
		currentActivity = new Activity(currentDailySteps, currentDailyCalories);

		Runnable runnable = new Runnable() {
			public void run() {
				int sensorfeedback[] = sensor.meassureActivity();
				currentActivity.recordActivity(sensorfeedback[0], sensorfeedback[1], sensorfeedback[2]);
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
		for (int i = saveActivities.length - 1; i >= 1; i--) {
			saveActivities[i] = saveActivities[i - 1];
		}
	}

	public void startSleep() {
		sleep = new Sleep();
		Runnable runnable = new Runnable() {
			public void run() {
				int sensorfeedback = sensor.meassureSleep();
				sleep.recordSleep(sensorfeedback);
			}
		};
		service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.MINUTES);
	}

	public void endSleep() {
		// end the loop for getting data from the sensor
		service.shutdown();
		// update DailySteps and DailyCalories
		sleep.endSleep();
		// save activity in front of our "Database"
		for (int i = saveSleeps.length - 1; i >= 1; i--) {
			saveSleeps[i] = saveSleeps[i - 1];
		}
	}

	// every new Day this method stores the old DailyStep and DailyCaloriesObject
	// and create a new One for the current day
	private void checkDate() {
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			// set the current Date
			cal2 = Calendar.getInstance();
			Date date2 = new Date();
			cal2.setTime(date2);

			// check if it is a new Day
			if (cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR)
					&& cal1.get(Calendar.DAY_OF_YEAR) != cal2.get(Calendar.DAY_OF_YEAR)) {
				// move all the current saved Daily Calories one spot behind ( the last will be
				// overwritten)
				for (int i = saveDailyCalories.length - 1; i >= 1; i--) {
					saveDailyCalories[i] = saveDailyCalories[i - 1];
				}
				// save the current one as the first element
				saveDailyCalories[0] = currentDailyCalories;
				// create a new DailyCalories for the new day
				currentDailyCalories = new DailyCalories();

				// same thing for DailySteps
				for (int i = saveDailySteps.length - 1; i >= 1; i--) {
					saveDailySteps[i] = saveDailySteps[i - 1];
				}
				saveDailySteps[0] = currentDailySteps;
				currentDailySteps = new DailySteps();

			}
		}), new KeyFrame(Duration.seconds(180)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();

	}

	// help methods:
	private void setUpDailyCalories() {
		currentDailyCalories = new DailyCalories();
		// fill saveDailyCalories with empty data
		for (int i = 0; i < saveDailyCalories.length; i++) {
			saveDailyCalories[i] = new DailyCalories();
		}
	}

	private void setUpDailySteps() {
		currentDailySteps = new DailySteps();
		// fill saveDailySteps with empty data
		for (int i = 0; i < saveDailySteps.length; i++) {
			saveDailySteps[i] = new DailySteps();
		}
	}

	private void setUpSleep() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date;
		Date date2;
		try {
			date = format.parse("1000/01/01 00:00:00");
			date2 = format.parse("1000/01/02 00:00:00");
			sleep = new Sleep(date, date2);
		} catch (ParseException e) {
			sleep = new Sleep();
			e.printStackTrace();
		}
		// fill saveDailySteps with empty data
		for (int i = 0; i < saveSleeps.length; i++) {
			saveSleeps[i] = new Sleep();
		}
	}

	private void setUpActivities() {
		// fill saveDailySteps with empty data
		for (int i = 0; i < saveActivities.length; i++) {
			saveActivities[i] = new Activity(null, null);
		}
	}

	// getter and setter methods
	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Activity getCurrentActivity() {
		return currentActivity;
	}

	public int getDailyCalories() {
		return currentDailyCalories.getDailyCalories();
	}

	public int getDailySteps() {
		return currentDailySteps.getDailySteps();
	}

	public Sleep getSleep() {
		return sleep;
	}

	public void setStepGoal(int stepGoal) {
		this.stepGoal = stepGoal;
	}

	public int getStepGoal() {
		return stepGoal;
	}

	public void setCaloriesGoal(int caloriesGoal) {
		this.caloriesGoal = caloriesGoal;
	}

	public int getCaloriesGoal() {
		return caloriesGoal;
	}

	public void calculateStepGoal() {
		// invent a formula with age and weight
		if (age > 20 && age < 40) {
			stepGoal = 140000;
		} else if (age > 10 && age < 60) {
			stepGoal = 10000;
		} else {
			stepGoal = 8000;
		}

	}

	public void calculateCaloriesGoal() {
		// using this formula https://en.wikipedia.org/wiki/Schofield_equation
		if (genderFemale == false) {
			if (age < 3) {
				caloriesGoal = (int) (59.512 * weight - 30.4);
			} else if (age >= 3 && age < 10) {
				caloriesGoal = (int) (22.706 * weight + 504.3);
			} else if (age >= 10 && age < 18) {
				caloriesGoal = (int) (17.686 * weight + 658.2);
			} else if (age >= 18 && age < 30) {
				caloriesGoal = (int) (15.057 * weight + 692.2);
			} else if (age >= 30 && age < 60) {
				caloriesGoal = (int) (11.472 * weight + 873.1);
			} else {
				caloriesGoal = (int) (11.711 * weight + 587.7);
			}
		} else {
			if (age < 3) {
				caloriesGoal = (int) (58.317 * weight - 31.1);
			} else if (age >= 3 && age < 10) {
				caloriesGoal = (int) (20.315 * weight + 485.9);
			} else if (age >= 10 && age < 18) {
				caloriesGoal = (int) (13.384 * weight + 692.6);
			} else if (age >= 18 && age < 30) {
				caloriesGoal = (int) (14.818 * weight + 486.6);
			} else if (age >= 30 && age < 60) {
				caloriesGoal = (int) (8.126 * weight + 845.6);
			} else {
				caloriesGoal = (int) (9.082 * weight + 658.5);
			}
		}
	}

	public void setGender(boolean b) {
		genderFemale = b;
	}
}
