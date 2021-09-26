package exercisesChapter1;

import java.math.BigDecimal;

public class Exercises {

    public static void main(String[] args) {
        exe113(args);
    }
    static public  void exe111(){
        System.out.println((0 + 15) / 2); // a 7 since converts it to int which truncates values
        System.out.println((2e-6 * 100000000.1)); // b 200.0000002 float
        System.out.println(true && false || true && true); // c boolean
    }
    static public void exe112(){
        System.out.println((1 + 2.236) / 2); // a double 1.618
        System.out.println((1 + 2 + 3 + 4.0)); // b double 10.0
        System.out.println(4.1 >= 4); // c compares by converting 4 ro double
        System.out.println((1 + 2 + "3")); // d string "33"
    }
    static public void exe113(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        if (num3 == num2 && num2 == num1) System.out.println("equal");
        else System.out.println("not equal");
    }
}
