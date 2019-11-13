package ch.makery.adress.junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.makery.adress.model.Activity;
import ch.makery.adress.model.DailyCalories;
import ch.makery.adress.model.DailySteps;

public class DailyStepsTest {
    DailySteps testDailySteps = new DailySteps();

    @Test
    public void testSetDailySteps() {
        testDailySteps.setSteps(1000);
        String actual = Integer.toString(testDailySteps.getDailySteps());
        String expected = "1000";
        assertEquals (expected, actual);
    }

    @Test
    public void testAddDailySteps() {
        testDailySteps.setSteps(250);
        testDailySteps.addSteps(250);
        String actual = Integer.toString(testDailySteps.getDailySteps());
        String expected = "500";
        assertEquals(expected,actual);
    }

    @Test
    public void testSubtractDailySteps() {
        testDailySteps.setSteps(250);
        testDailySteps.subtractSteps(250);
        String actual = Integer.toString(testDailySteps.getDailySteps());
        String expected = "0";
        assertEquals(expected,actual);
    }

    @Test
    public void testGetDailySteps() {
        String actual = Integer.toString(testDailySteps.getDailySteps());
        String expected = "0";
        assertEquals(expected,actual);
    }

}
