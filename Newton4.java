import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program uses the Newton Iteration to find the square root of inputed
 * values
 *
 * @author Daniel Legesse
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x, double e) {
        // Initialize that guess is inputed value as suggested in assignment
        double r = x;
        // Until |r^2-x|/x < E^2, continues to update r
        if (x == 0) {
            r = 0;
        } else {
            while (Math.abs((r * r) - x) / x > (e * e)) {
                r = (r + (x / r)) / 2;
            }
        }

        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // Initialize boolean for the ability to run again
        boolean playAgain = true;
        while (playAgain) {
            // Receive the number to be square rooted
            out.println("Number: ");
            double x = in.nextDouble();
            if (x >= 0) {
                // Receive the E-value used for relative error
                out.println("E-Value: ");
                double e = in.nextDouble();
                // call 'sqrt' method using inputed number
                double r = sqrt(x, e);
                out.println("Square Root: " + r);
                ;
            } else {
                playAgain = false;
            }

        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
