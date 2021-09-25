package algorithms;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int counter = 0;
        while (!StdIn.isEmpty()){
            sum += StdIn.readDouble();
            counter+=1;
        }
        double avg = sum / counter;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
