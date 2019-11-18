package ch.makery.adress.junitTest;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import ch.makery.adress.model.Sensor;

public class SensorTest {
	Sensor testSensor = new Sensor();

	@Test
	public void testSensor() {
		assertEquals("[100, 1000, 500]", Arrays.toString(testSensor.meassureActivityTest(100, 1000, 500)));
	}

	@Test
	public void testMeassureSleep() {
		assertEquals(100, testSensor.meassureSleepTest(100));
	}

	@Test
	public void testMeassureMeters() {
		assertEquals(500, testSensor.meassureMetersTest(500));
	}

}
