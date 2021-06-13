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
        * */
        var jabberer = new TalkingClock(1000, true);
        TalkingClock.TimePrinter listener = jabberer.new TimePrinter();
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
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}