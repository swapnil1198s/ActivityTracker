package ch.makery.adress.model;

import java.util.Scanner;

public class Sensor {
	private int meters; 
    Scanner scanner = new Scanner(System.in);
    
    public int [] meassureActivity () {
    	System.out.print("current Heartrate: ");
    		int heartrate = scanner.nextInt();
    		System.out.print("steps in last 30 seconds: ");
    		int steps = scanner.nextInt();
    		
    		int [] result = {heartrate,meters, steps}; 
    		return result;
    }

	public int meassureSleep() {
		System.out.print("current Heartrate: ");
		return scanner.nextInt();
	}

	public int meassureMeters() {
		System.out.print("Meters in last 30 seconds: ");
		meters = scanner.nextInt();
		return meters; 
	}
}

	


