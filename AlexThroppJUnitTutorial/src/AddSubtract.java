public class AddSubtract {
private int currentVal;
/**
 5 * Constructor to initialize our member variable.
 */
        public AddSubtract(int a) {
            currentVal = a;
}

         /**
  * Add the value of 'a' to our current value.*/
         public void add(int a) {
            currentVal += a;
         }

         /**
 19 * Subtract the value of 'a' from our current value.
 20 */
         public void subtract(int a) {
            currentVal -= a;
         }

         /**
 26 * Get the current value.
 27 */
         public int getCurrentVal() {
            return currentVal;
         }
 }