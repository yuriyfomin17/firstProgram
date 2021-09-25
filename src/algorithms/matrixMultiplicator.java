package algorithms;

import java.util.Arrays;

public class matrixMultiplicator {
    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int[][] array2 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int[][] array3 = new int[array1.length][array2.length];
        dotProduct(array1, array2, array3);
    }

    public static void dotProduct(int[][] arr1, int[][] arr2, int[][] arr3) {
        int rowLength = arr1.length;
        int colLength = arr2[0].length;
        if (rowLength != colLength) return;
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                for (int i = 0; i < rowLength; i++) {
                    arr3[c][r] += arr1[r][i] * arr2[i][c];
                }

            }
        }
        System.out.println(Arrays.deepToString(arr3));

    }
}
