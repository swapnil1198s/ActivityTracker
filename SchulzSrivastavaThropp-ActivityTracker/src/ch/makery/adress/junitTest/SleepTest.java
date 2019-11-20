package ch.makery.adress.junitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.makery.adress.model.Sleep;

public class SleepTest {

	Sleep slp = new Sleep();

	@Test
	public void testGetSleepTime() {
		int hours = 8;

		slp.startSleepForTesting();
		System.out.println("start time: " + slp.getSleepStartTime());
		try {
			// time to sleep in milliseconds
			Thread.sleep(hours * 1000);
		} catch (InterruptedException e) {

		}
		slp.endSleep();
		System.out.println("end time: " + slp.getSleepEndeTime());
		System.out.println("sleep time: " + slp.getSleepTime());

		// 480 b/c 8hours*60min
		assertEquals(480, slp.getSleepTime());
	}

	@Test
	public void testGetSleepLevel() {
		int hours = 8;
		slp.startSleepForTesting();
		try {
			// time to sleep in milliseconds
			Thread.sleep(hours * 1000);
		} catch (InterruptedException e) {
		}
		slp.endSleep();
		slp.recordSleep(55);

		System.out.println("sleep time: " + slp.getSleepTime());
		System.out.println("sleep level: " + slp.getLevel());

		assertEquals(5, slp.getLevel());
	}

    @Test
    public void testGetSleepLevel4(){
        int hours = 7;
        slp.startSleepForTesting();
        try {
            //time to sleep in milliseconds
            Thread.sleep(hours * 1000);
        }
        catch(InterruptedException e){
        }
        slp.endSleep();
        slp.recordSleep(55);

        System.out.println("sleep time: " + slp.getSleepTime());
        System.out.println("sleep level: " + slp.getLevel());

        assertEquals(4,slp.getLevel());
    }

    @Test
    public void testGetSleepLevel3(){
        int hours = 6;
        slp.startSleepForTesting();
        try {
            //time to sleep in milliseconds
            Thread.sleep(hours * 1000);
        }
        catch(InterruptedException e){
        }
        slp.endSleep();
        slp.recordSleep(55);

        System.out.println("sleep time: " + slp.getSleepTime());
        System.out.println("sleep level: " + slp.getLevel());

        assertEquals(3,slp.getLevel());
    }

    @Test
    public void testGetSleepLevel2(){
        int hours = 5;
        slp.startSleepForTesting();
        try {
            //time to sleep in milliseconds
            Thread.sleep(hours * 1000);
        }
        catch(InterruptedException e){
        }
        slp.endSleep();
        slp.recordSleep(55);

        System.out.println("sleep time: " + slp.getSleepTime());
        System.out.println("sleep level: " + slp.getLevel());

        assertEquals(2,slp.getLevel());
    }
    @Test
    public void testGetSleepLevel1_badHeartRate(){
        int hours = 7;
        slp.startSleepForTesting();
        try {
            //time to sleep in milliseconds
            Thread.sleep(hours * 1000);
        }
        catch(InterruptedException e){
        }
        slp.endSleep();
        slp.recordSleep(101);

        System.out.println("sleep time: " + slp.getSleepTime());
        System.out.println("sleep level: " + slp.getLevel());

        assertEquals(1,slp.getLevel());
    }

    @Test
    public void testGetSleepLevel1_badSleepTime(){
        int hours = 1;
        slp.startSleepForTesting();
        try {
            //time to sleep in milliseconds
            Thread.sleep(hours * 1000);
        }
        catch(InterruptedException e){
        }
        slp.endSleep();
        slp.recordSleep(55);

        System.out.println("sleep time: " + slp.getSleepTime());
        System.out.println("sleep level: " + slp.getLevel());

        assertEquals(1,slp.getLevel());
    }
}
