package learnMethodReference;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.util.Arrays;

public class learnMethodReference {
    public static void main(String [] args){

        /*
        * Another example
        * */

        var list = new String[]{"Yuriy", "Bohdan", null};
        System.out.println(Arrays.toString(list));

        System.out.println();
       /*
        * The expression System.out::println is a method reference
        * It directs the compiler to produce an instance of a functional interface
        * overriding the single abstract method of the interface to call a given method
        *
        * In this example, an ActionListener is produced whose actionPerformed(ActionEvent e)
        * method calls System.out.println(e)
        *
        * In the example below, there are ten overloaded method of the PrintStream class
        * of which System.out is an instance. The compiler needs to figure out which method
        * to choose. Out of all println(Object object) is the best matched.
        *
        * When the actionPerformed method is called, the even object is printed*/
        var timer = new Timer(1000, System.out::println);
//        timer.start();
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);
    }
}

class Greeter{
    public void greet(ActionEvent event){
        System.out.println("Hello, the time is " + Instant.ofEpochMilli(event.getWhen()));
    }
}

class RepeatedGreeter extends Greeter{
    @Override public void greet(ActionEvent event){
        var timer = new Timer(1000, super::greet);
        timer.start();
    }
    public static void main(String[] args){
        var obj = new RepeatedGreeter();
        /*
        * Constructor references like method references, expect that
        * the name of the method is new. For example, Person::new is a reference to a Person
        * constructor. Which constructor ? It depends on the context.
        *  */
    }
}
