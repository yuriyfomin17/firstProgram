package exercisesChapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercises {

    public static void main(String[] args) {
        exe1120();
    }

    static public void exe111() { // ✅ checked
        System.out.println((0 + 15) / 2); // a 7 since converts it to int which truncates values
        System.out.println((2e-6 * 100000000.1)); // b 200.0000002 float
        System.out.println(true && false || true && true); // c boolean
    }

    static public void exe112() { // ✅ checked
        System.out.println((1 + 2.236) / 2); // a double 1.618
        System.out.println((1 + 2 + 3 + 4.0)); // b double 10.0
        System.out.println(4.1 >= 4); // c compares by converting 4 ro double
        System.out.println((1 + 2 + "3")); // d string "33"
    }

    static public void exe113(String[] args) { // ✅ checked
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        if (num3 == num2 && num2 == num1) System.out.println("equal");
        else System.out.println("not equal");
    }

    static public void exe116() { //  ✅ checked -> fibonacci sequence
        long f = 0;
        long g = 1;
        for (int i = 0; i < 100; i++) {
            StdOut.println(i + " " + f);
            f = f + g;
            g = f - g;
        }
    }

    static public void exe117() { //  ✅ checked
        //  Newtonian method to find square root of number => 3.00009
        double sqrtNum = 9.0;
        double c = sqrtNum;
        while (Math.abs(sqrtNum - c / sqrtNum) > 0.001) {
            sqrtNum = (sqrtNum + c / sqrtNum) * 0.5;
        }
        StdOut.printf("%.5f\n", sqrtNum);

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

    static public void exe119() { // ✅ checked -> implementation of toBinaryString method
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

    static public void exe1113() { // ✅ checked -> transpose matrix
        class Printer{
            public static void print(int[][] mat) {
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        StdOut.print(mat[i][j] + " ");
                    }
                    StdOut.println();
                }

            }
        }
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Printer.print(matrix);
        System.out.println();
        int rowLength = matrix[0].length;
        int columnLength = matrix.length;
        int[][] transposeMatrix = new int[rowLength][columnLength];
        for (int r = 0; r < columnLength; r++) {
            for (int c = 0; c < rowLength; c++) {
                transposeMatrix[c][r] = matrix[r][c];
            }
        }
        Printer.print(transposeMatrix);


    }

    static public void exe1114() { // ✅ checked
        // Write a static method lg() that takes an int
        // value N as argument and returns the largest int not larger than the base-2 logarithm of N. Do not use Math.
        // log2(N) = ln(N)/ln(2) = x
        // ln(N) =  ln(2) * x
        // apply rule of exponents => N = 2^x
        int N = 17;
        int accumulator = 1;
        int powerOfTwoCount = 0;
        while (accumulator * 2 <= N) {
            powerOfTwoCount += 1;
            accumulator *= 2;
        }

        System.out.println((powerOfTwoCount));
    }

    static public void exe1115() { // ✅ checked
        int[] array = {1, 2, 3, 9};
        int M = 7;
        int[] result = new int[M];
        HashMap<Integer, Integer> info = new HashMap();
        for (int el : array) {
            if (info.containsKey(el)) info.put(el, info.get(el) + 1);
            else info.put(el, 1);
        }
        for (Map.Entry<Integer, Integer> entry : info.entrySet()) {
            if (entry.getKey() < result.length) result[entry.getKey()] = entry.getValue();
        }
        System.out.println(Arrays.toString(result));
    }

    public static String exe1116(int n) { // ✅ checked -> 311361142246
        if (n <= 0) {
            return "";
        }
        return exe1116(n - 3) + n + exe1116(n - 2) + n;
    }

    // a, b - 2, 25 => 50; a,b - 3, 11 => 33
    // given pos integers exe1118 multiplies a * b
    // mystery two computes A^B
    public static int exe1118(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return exe1118(a + a, b / 2);
        return exe1118(a + a, b / 2) + a;
    }

    public static void exe1119() { // ✅ checked
        // largest n for which it takes less then hour to compute fibonacci is 49
        // enhanced with memoization
        class Fibonacci {
            public static long F(int N, long[] info) {
                if (N == 0) return 0;
                if (N == 1) return 1;
                if (info[N-1] != 0) return info[N-1];
                long result =  F(N - 1, info) + F(N - 2, info);
                info[N-1] = result;
                return result;
            }
        }
        for (int N = 0; N < 100; N++){
            long result = Fibonacci.F(N, new long[N]);
            StdOut.println(N + " " + result);
        }

    }
    public static void exe1120(){
        // calculate ln(N!) enhanced by memoization. However, doesn't need it , since recursion calls just one recursive fucntion
        class Factorial{
            public static long F(int N, long[] info){
                if (N == 0) return 1;
                if (info[N-1] != 0) return info[N-1];
                long result =  N * F(N -1, info);
                info[N-1] = result;
                return result;
            }
        }
        System.out.println(Math.log(Factorial.F(5, new long[5])));
    }
    public static void exe1121(){
        // simple printer program
        // each line contain- ing a name and two integers and then uses printf() to print a table with a column of the names, the integers, and the result of dividing the first by the second, accurate to three decimal places.
        // You could use a program like this to tabulate batting averages for baseball players or grades for students.
        ArrayList<String> info = new ArrayList<>();
        while (!StdIn.isEmpty()){
            String string = StdIn.readLine();
            info.add(string.trim());
        }
        for (String s: info) {
            String[] args = s.split(",");
            String name = args[0];
            Integer num1 = Integer.parseInt(args[1]);
            Integer num2 = Integer.parseInt(args[2]);
            Double num3 = ((double) num1) / ((double) num2);
            System.out.println("----------------------------");
            StdOut.printf("| %s | %d | %d | %f |\n", name, num1, num2 , num3 );
        }
        System.out.println("----------------------------");
    }

    public static void exe1122(){
        int [] arr = {1, 2, 3, 4, 5, 6,7, 8, 9};
        class RecursiveBinarySearch{
            public static int search(int[]arr , int lo, int hi, int target, int depth){
                int mid = lo + (hi - lo) / 2;
                System.out.printf("lo %d, hi %d, depth %d\n", lo, hi, depth);
                depth+=1;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) return search(arr, mid + 1, hi, target, depth);
                if (arr[mid] > target) return search(arr, lo, mid - 1, target, depth);
                return -1;
            }
        }
        System.out.println(RecursiveBinarySearch.search(arr, 0, arr.length -1, 9, 0));
    }

    public static void exe1124(){
        class EuclidGreatestCommonDivisor{
            public static int gcd(int num, int divisor){
                System.out.printf("Numerator=%d, denominator=%d\n", num, divisor);
                if (num % divisor == 0) return divisor;
                int remainder = num % divisor;
                return gcd(divisor , remainder);
            }
        }
        System.out.println(EuclidGreatestCommonDivisor.gcd(1234567, 1111111));
    }

}
