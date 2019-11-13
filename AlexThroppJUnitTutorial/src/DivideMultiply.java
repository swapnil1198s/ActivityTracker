public class DivideMultiply {
 private double currentVal;

         /**
 5 * Constructor to initialize our member variable.
 6 */
         public DivideMultiply(double a) {
         currentVal = a;
         }

         /**
 12 * Multiply 'a' with our current value.
 13 */
         public void multiply(double a) {
         currentVal *= a;
         }

         /**
 19 * Divide 'a' from our current value.
 20 */
         public void divide(double a) {
         if (a == 0.0) {
             throw new java.lang.ArithmeticException("Can't divide by zero!");
             }

         currentVal /= a;
         }

         /**
 30 * Get the current value.
 31 */
         public double getCurrentVal() {
         return currentVal;
         }
 }