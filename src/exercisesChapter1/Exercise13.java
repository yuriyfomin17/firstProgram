package exercisesChapter1;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise13 {
    public static void main(String[] args) {
        StdOut.print(lg(15));
        StdOut.println("\nExpected: 3");
    }

    private static int lg(int n) {

        int logInt = 0;

        while (n > 0) {
            logInt++;

            n /= 2;
        }

        return logInt - 1;
    }
}
