import static org.junit.Assert.*;
 import org.junit.Before;
 import org.junit.Test;


 public class AddSubtractTest {
 private AddSubtract as; // An instance of the class under test

         /**
 9 * This '@Before' method is ran before every '@Test' method
 10 */
         @Before
 public void setUp() throws Exception {
         as = new AddSubtract(4);
         }

         /**
 17 * Test method for add()
 18 */
         @Test
 public void testAdd() {
         as.add(5);
         assertEquals(9, as.getCurrentVal());
         as.add(3);
         assertEquals(12, as.getCurrentVal());
         }

         /**
 28 * Test method for subtract()
 29 */
         @Test
 public void testSubtract() {
         as.subtract(5);
         assertEquals(-1, as.getCurrentVal());
         as.subtract(-3);
         assertEquals(2, as.getCurrentVal());
         }

         /**
 39 * Test method for getCurrentVal()
 40 */
         @Test
 public void testGetCurrentVal() {
         assertEquals(4, as.getCurrentVal());
         }
 }