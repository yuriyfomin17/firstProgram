package learningInnerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.*;

public class learningInnerClass {
    public static void main(String[] args){
        /* This is how instance of inner class of TalkingClock is created with the double brackets
        *  Inner class can not have an constructors but inside the brackets we can provide
        * an initialization*/
        var clock2 = new TalkingClock(1000, false){};
        var clock = new TalkingClock(1000, false);
        clock.start();
        // keep program running until the user selects "OK"
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);

        /*
        * It is possible to set the outer class reference to another object
        * by explicitly naming it. For example TimePrinter is a public inner class,
        * you can construct a TimePrinter for any talking clock
        *
        * It worth noting that inner classes are a phenomen of the compiler
        * not a virtual machine. Inner classes are translated into regular class files
        * with $signs
        * */
//        var jabberer = new TalkingClock(1000, true);
//        TalkingClock.TimePrinter listener = jabberer.new TimePrinter();
    }


}
/*
* As inner class is just a simple class here we try to see if normal class
* TimerPrinter2 can have an access to the private field beep?
*
* And answer is no.
* */
class TimePrinter2 implements ActionListener{
    private TalkingClock outer;
    public TimePrinter2(TalkingClock anOuter){
        this.outer = anOuter;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is "
                + Instant.ofEpochMilli(event.getWhen()));
        if (this.outer.isBeep()) Toolkit.getDefaultToolkit().beep();
    }
}
class TalkingClock{
    private final int interval;
    private final boolean beep;
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){
        var listener = new TimePrinter();
        var timer = new Timer(this.interval, listener);
        timer.start();
    }

    public boolean isBeep() {
        return beep;
    }

    /*
    * Note that inner class TimePrinter has access to the variables of the outer class
    * TalkingClock
    *
    *
    * Only, inner class such as TimePrinter could have been
    * private, usually regular classes always have either package or public access*/
    class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is "
            + Instant.ofEpochMilli(event.getWhen()));
            /*
            * Below if statement is transformed into TalkingClock.access$0(outer)
            * which accesses the private field of the outer class
            * */
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
    /*
    * Example of the local inner class.
    * Local classes are never declared with an access specifier
    * that is public or private .
    *
    * Local classes have one great advantage is that they are hidden
    * from the outside world. No method expect start has any
    * knowledge of the TimePrinter class
    *
    *
    * Also note how we access the variable from the outer method run
    *
    * For the code in the actionPerformed method to work
    * the TimePrinter class must have copied the beep field
    * as a local of the run method
    *
    * 1. The run method is called
    * 2. The object variable listener is initialized by a call to the constructor of the inner
    * class TimePrinter
    * 3. The listener reference is passed to the Timer constructor, the timeis is started
    * and method run is exited. Beep parameter variable is no longer exists. However,
    * inner class TimePrinter3 has coped this beep value
    *
    * 4. A second later, the actionPerformed method executes if (beet)*/
    public void run(int interval, boolean beep){
        class TimePrinter3 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is "
                        + Instant.ofEpochMilli(event.getWhen()));
                /*
                 * Below if statement is transformed into TalkingClock.access$0(outer)
                 * which accesses the private field of the outer class
                 * */
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        var listener = new TimePrinter3();
        var timer = new Timer(this.interval, listener);
        timer.start();

    }
    /* This is an example of the anonymous inner classes
    * Syntax is a bit cryptic but it means: create new object of a class
    * that implements the ActionListener interface, where the required method actionPerformed is the one
    * defined inside the braces
    * */
    public void start(int interval, boolean beep) {
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep(); }
        };
        var timer = new Timer(interval, listener);
        timer.start(); }
    /*
    * Example of the anonymous inner class but with the lambda expression
    * Reminder: behind the scene of lambda expression the object of the class that implements ActionPerformed interface
    * is created. And it has the method that is going to be used in this class
    * */
    public void start2(int interval, boolean beep) {
        var timer = new Timer(interval, event -> { System.out.println("At the tone, the time is "
                + Instant.ofEpochMilli(event.getWhen())); if (beep) Toolkit.getDefaultToolkit().beep();
        });
        timer.start(); }
    public static void main(String[] args){
        var clock = new TalkingClock(1000, true);
        clock.start2(1000, true);
        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}