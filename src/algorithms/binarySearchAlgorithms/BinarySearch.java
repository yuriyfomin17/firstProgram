package algorithms.binarySearchAlgorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()){
            int target = StdIn.readInt();
            if (rank(whitelist, target) == -1){
                StdOut.println(target);
            }
        }
    }
    public static int rank(int[] array, int  target){
        int low = 0;
        int high = array.length - 1;
        while (low<= high){
            int mid = low + (high - low) / 2;
            if (target < array[mid]) high = mid -1;
            else if (target > array[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
