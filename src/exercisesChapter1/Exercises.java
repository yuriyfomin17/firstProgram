package exercisesChapter1;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigDecimal;
import java.util.Arrays;

public class Exercises {

    public static void main(String[] args) {
        exe1113();
    }

    static public void exe111() {
        System.out.println((0 + 15) / 2); // a 7 since converts it to int which truncates values
        System.out.println((2e-6 * 100000000.1)); // b 200.0000002 float
        System.out.println(true && false || true && true); // c boolean
    }

    static public void exe112() {
        System.out.println((1 + 2.236) / 2); // a double 1.618
        System.out.println((1 + 2 + 3 + 4.0)); // b double 10.0
        System.out.println(4.1 >= 4); // c compares by converting 4 ro double
        System.out.println((1 + 2 + "3")); // d string "33"
    }

    static public void exe113(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        if (num3 == num2 && num2 == num1) System.out.println("equal");
        else System.out.println("not equal");
    }

    static public void exe116() { // fibonacci sequence
        int f = 0;
        int g = 1;
        for (int i = 0; i < 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    static public void exe117() {
        // a
        double sqrtNum = 9.0;
        double c = sqrtNum;
        while (Math.abs(sqrtNum - c / sqrtNum) > 0.001) {
            sqrtNum = (sqrtNum + c / sqrtNum) * 0.5;
        }
        StdOut.printf("%.5f\n", sqrtNum); // Newtonian method to find square root of number => 3.00009

        // b
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum); // 499500

        int N = 10;
        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < N; j++)
                sum2++;
        StdOut.println(sum2); // 100
    }

    static public void exe118() {
        System.out.println("b"); // prints b
        System.out.println("b" + "c"); // prints "bc"
        System.out.println((char) ('a' + 4)); // converts 'a' to 97 according to ascii table and add up 4 to 97 which is 101 then char converts 101 to 'e'
    }

    static public void exe119() {
        int num = 9;
        System.out.println(Integer.toBinaryString(num));

        String binaryNum = "";
        for (int i = num; i > 0; i /= 2) {
            binaryNum = (i % 2) + binaryNum;
        }
        System.out.println(binaryNum);
    }

    static public void exe1112() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
    // transpose matrix
    static public void exe1113() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int rowLength = matrix[0].length;
        int columnLength = matrix.length;
        int[][] transposeMatrix = new int[rowLength][columnLength];
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(transposeMatrix));

    }
}
