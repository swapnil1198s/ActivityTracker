package ch.makery.adress.model;

import java.util.Scanner;

public class Sensor {
	private int meters;
	private int heartrate;
	private int steps;
	Scanner scanner = new Scanner(System.in);

	public int[] meassureActivity() {
		System.out.print("current Heartrate: ");
		heartrate = scanner.nextInt();
		System.out.print("meters in last 30 seconds: ");
		meters = scanner.nextInt();

		int[] result = { heartrate, meters, steps };
		return result;
	}

	public int meassureSleep() {
		System.out.print("current Heartrate: ");
		return scanner.nextInt();
	}

	public int meassureSteps() {
		System.out.print("Steps in last 30 seconds: ");
		steps = scanner.nextInt();
		return steps;
	}

	// methods for test. same as above but they have hard coded input values instead
	// of scanner
	public int[] meassureActivityTest(int amountH, int amountS, int amountM) {
		heartrate = amountH;
		steps = amountS;
		meters = amountM;

		int[] result = { heartrate, steps, meters };
		return result;
	}

	public int meassureSleepTest(int amountH) {
		return heartrate = amountH;
	}

	public int meassureMetersTest(int amountM) {
		return meters = amountM;
	}
}
