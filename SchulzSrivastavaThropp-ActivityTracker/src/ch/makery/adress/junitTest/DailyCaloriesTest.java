package ch.makery.adress.junitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import ch.makery.adress.model.DailyCalories;

public class DailyCaloriesTest {
	DailyCalories testDailyCal = new DailyCalories();

	@Test
	public void testSetDailyCal() {
		testDailyCal.setCalories(250);
		String actual = Integer.toString(testDailyCal.getDailyCalories());
		String expected = "250";
		assertEquals(expected, actual);
	}

	@Test
	public void testAddDailyCal() {
		testDailyCal.setCalories(250);
		testDailyCal.addCalories(250);
		String actual = Integer.toString(testDailyCal.getDailyCalories());
		String expected = "500";
		assertEquals(expected, actual);
	}

	@Test
	public void testSubtractDailyCal() {
		testDailyCal.setCalories(250);
		testDailyCal.subtractCalories(250);
		String actual = Integer.toString(testDailyCal.getDailyCalories());
		String expected = "0";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDailyCal() {
		String actual = Integer.toString(testDailyCal.getDailyCalories());
		String expected = "0";
		assertEquals(expected, actual);
	}

}
