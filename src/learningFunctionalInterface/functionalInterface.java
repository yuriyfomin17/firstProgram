package learningFunctionalInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class functionalInterface {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1,2,3,4,5);
        System.out.println(arrayList);
        Integer[] array = arrayList.toArray(Integer[]::new);
        System.out.println("hi");

//       Задача 3. Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
//        Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное число делится
//        без остатка на 13.
        Divisible divisible = (num)->{
            return  num%13 == 0;
        };
        System.out.println(divisible.checkDivision(13));
//Задача 4. Написать функциональный интерфейс с методом, который принимает две строки и возвращает тоже строку.
// Написать реализацию такого интерфейса в виде лямбды, которая возвращает ту строку, которая длиннее.
        StringLonger stringLonger = (s1, s2) -> {
            if (s1.length() > s2.length()) return s1;
            else return s2;
        };
        System.out.println(stringLonger.longerString("Yuriy", "Bogdan"));
// Задача 5. Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c и возвращает тоже дробное число.
// Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает дискриминант.
// Кто забыл, D = b^2 — 4ac.
        Discrimenant discrimenant = (a, b, c)->{
            return  Math.pow(b, 2) - 4 * a * c;
        };
        System.out.println(discrimenant.descrimenant(5.0, 2.0, 2.0));

    }
}

interface Divisible{
    boolean checkDivision(Integer num);
}

interface StringLonger{
    String longerString(String s1, String s2);
}
interface Discrimenant{
    Double descrimenant(Double a, Double b , Double c);

}
