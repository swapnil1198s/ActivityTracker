package ch.makery.adress.junitTest;
import static org.junit.Assert.*;
import java.lang.*;
import org.junit.Test;
import ch.makery.adress.model.Sleep;

public class SleepTest {

    Sleep slp = new Sleep();

    @Test
    public void testGetSleepTime(){
        int hours = 8;

        slp.startSleepForTesting();
        System.out.println("start time: " + slp.getSleepStartTime());
        try {
            //time to sleep in milliseconds
            Thread.sleep(hours * 1000);
        }
        catch(InterruptedException e){

        }
        slp.endSleep();
        System.out.println("end time: " + slp.getSleepEndeTime());
        System.out.println("sleep time: " + slp.getSleepTime());


        //480 b/c 8hours*60min
        assertEquals(480,slp.getSleepTime());
    }

    @Test
    public void testGetSleepLevel(){
        int hours = 8;
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

        assertEquals(5,slp.getLevel());
    }
}

