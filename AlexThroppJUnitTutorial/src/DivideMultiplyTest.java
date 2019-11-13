import static org.junit.Assert.*;
 import org.junit.Before;
 import org.junit.Test;

         public class DivideMultiplyTest {
 private DivideMultiply dm; // An instance of the class under test

         /**
 9 * This '@Before' method is ran before every '@Test' method
 10 */
         @Before
 public void setUp() throws Exception {
         dm = new DivideMultiply(3.0);
         }

         /**
 17 * Test method for multiply()
 18 */
         @Test
 public void testMultiply() {
         dm.multiply(2.0);
         assertEquals(6.0, dm.getCurrentVal(), 0.0000001);
         }

         /**
 26 * Test method for divide()
 27 */
         @Test
 public void testDivide() {
         dm.divide(2.0);
         assertEquals(1.5, dm.getCurrentVal(), 0.0000001);
         }

         /**
 35 * Test method for the exception that divide() throws
 36 */
         @Test(expected=java.lang.ArithmeticException.class)
 public void testDivideByZero() {
         dm.divide(0.0);
         }

         /**
 43 * Test method for getCurrentVal()
 44 */
         @Test
 public void testGetCurrentVal() {
         assertEquals(3.0, dm.getCurrentVal(), 0.0000001);
         }
 }