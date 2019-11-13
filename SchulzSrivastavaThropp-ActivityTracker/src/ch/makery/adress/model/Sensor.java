package ch.makery.adress.model;

import java.util.Scanner;

public class Sensor {
	private int heartrate; 
	private int meters; 
	private int steps; 
	
	
    Scanner scanner = new Scanner(System.in);

    public void setVariables(int amountH, int amountM, int amountS){
    	heartrate = amountH;
    	meters = amountM;
    	steps = amountS;
	}

    public int [] meassureActivity () {
    	System.out.print("current Heartrate: ");
    		heartrate = scanner.nextInt();
    		System.out.print("Meters in last 30 seconds: ");
    		meters = scanner.nextInt();
    		System.out.print("steps in last 30 seconds: ");
    		steps = scanner.nextInt();
    		
    		int [] result = {heartrate, meters,steps}; 
    		return result;
    }

	public int meassureSleep() {
		System.out.print("current Heartrate: ");
		return scanner.nextInt();
	}
}

	


