import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.*;

public class learningInnerClass {
    public static void main(String[] args){
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
    * 2. The object variable listner is initialized by a call to the constructor of the inner
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
    public static void main(String[] args){
        var clock = new TalkingClock(1000, true);
        clock.run(1000, true);
        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}