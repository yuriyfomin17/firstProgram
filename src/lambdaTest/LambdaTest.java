package lambdaTest;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
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
        * you can use lambda whenever an object of an interface  with the single abstract method is expected
        * this is called functional interface. Behind the scene in sort lambda method object is created
        * that implements Comparator<String> interface with the corresponding method
        *
        * The thing about lambda is that you can't just pass the executable block of code from one place to another
        * instead you have to construct an instance of worker class that implements some interface Comparator (i.e.)
        * it has a method that is going to be used by the object to carry out some work e.g. sorting
        *
        * You never specify the result type of the lambda expression. It is deduced from the context
        * */
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        /*
         * Second version of the interface. Behind the scenes array sort receives some object
         * that implements interface Comparator<String>
         */
        Comparator<String> comp = (first, second)->first.length() - second.length();
        Arrays.sort(planets, comp);
        System.out.println(Arrays.toString(planets));

        /*
        *
        * Another version of the lambada declaration
        * Also, note that you can't change variable inside
        * lambda expression as they are considered final
        *
        * This is because when code executed concurrently, serious issues might arise hence
        * it is more practical to keep it final
        * */
        ActionListener listener = event -> {System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();};
        var timer = new Timer(1000, event ->
        {System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();});
        var timer2 = new Timer(1000, listener);
        timer2.start();
        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
    public void init(){
        /*
        * this.toString() calls the toString method of the Application Object
        * not the ActionListener Instance
        * */
        ActionListener listener = event ->{
            System.out.println(this);
        };
    }
}

class Repeater implements IntConsumer{
    public void accept(int i ){
        System.out.println("Countdown: " + (9 - i));
    }
}
class LambdaTest2{
    public static void main(String[] args){
        var repeater = new Repeater();
        /*
        * How to process lambda expressions
        * */
        LambdaTest2.repeat(10, i->System.out.println("Countdown: " + (9 - i)));

        /*
         * same thing is done but shown what happens behind the scene
         * */
        LambdaTest2.repeat(10, repeater);
    }
    public static void repeat(int n, IntConsumer action){
        for(int i =0; i< n; i++) action.accept(i);
    }
}





class PersonNameCompare implements Comparator<Person>{
    public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }
}
class Person implements Comparable<Person>{
    private final String name;
    private final String lastName;
    private final Integer ID;
    public Person(String aName, String aLastName, Integer anID){
        this.name = aName;
        this.lastName = aLastName;
        this.ID = anID;
    }

    public String getName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }

    public String toString(){
        return "person[Name=" + this.name + "LastName=" + this.lastName+"]";
    }
    public int compareTo(Person p){
        return this.name.compareTo(p.getName());
    }
    public static void main(String[] args){
        /*
        * Example of how comparator is used
        * */
        var comparator = new PersonNameCompare();
        Set<Person> people = new TreeSet(comparator);
        var name = new String[]{"A", "B", "C", "D", "E", "F", "G", "K", "L", "R"};
        for(int i = 9; i > 0; i--){
            people.add(new Person(name[i], "Fomin", i));
        }
        for(Person person:people){
            System.out.println(person.toString());
        }
    }
}

