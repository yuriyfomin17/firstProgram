import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Math.*;
public class helloWorld {
    public static void main(String [] args){
        int numbersToPick = 6;
        int size = 50;
        int [] numbers = new int[size];
        for(int i =0; i< 50; i++){
            numbers[i] = i + 1;
        }
        int [] result = new int[numbersToPick];
        for(int k = 0; k< result.length; k++){
            int r = (int) Math.round(Math.random() * size);
            result[k] = numbers[r];
            numbers[r] = numbers[size - 1];
            size--;
        }
        Arrays.sort(result);
        for(int el : result){
            System.out.println(el);
        }
    }
}
