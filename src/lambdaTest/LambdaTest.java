package lambdaTest;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class LambdaTest {
    public static void main(String[] args){
        var planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        /*
        * lambda expression usage
        * you can use lambda whenever an object of an interface  with the single abstact method is excpected
        * this is called functional interface. Behind the scene in sort lambda method object is created
        * that implements Comparator<String> interface with the corresponding method
        *
        * The thing about lambda is that you can't just pass the executable block of code from one place to another
        * instead you have to construct an instance of worker class that implements some interface Comparator (i.e.)
        * it has a method that is going to be used by the object to carry out some work e.g. sorting
        *
        * You never specify the result type of the lambda expression
        * */
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        /*
         * Second version of the interface
         */
        Comparator<String> comp = (first, second)->first.length() - second.length();
        Arrays.sort(planets, comp);
        System.out.println(Arrays.toString(planets));

        /*
        * Another version of the lambada declaration
        * */
        ActionListener listener = event -> {System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();};
        var timer = new Timer(1000, event ->
        {System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();});
        timer.start();
        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

