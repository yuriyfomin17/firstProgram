package learnCallBack;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class learnCallBack {
    public static void main(String[] args){
        var listener = new TimePrinter();
        // construct a timer that calls the listener
         // once every second
        /* Instead of passing the function which timer calls periodically
        * we supply an object of some class then timer calls one of the methods
        * on that object. Passing an object is more flexible than passing a function
        * as object can carry additional information */
        var timer = new Timer(1000, listener);
        timer.start();
       // keep program running until the user selects "OK"
       JOptionPane.showMessageDialog(null, "Quit program?");
       System.exit(0);
    }
}

/*The time requires that you specify an object of a class
* that implements the learnCallBack.ActionListener interface
* of the java.awt.event package*/
interface ActionListener{
    void actionPerformed(ActionEvent event);
}

class TimePrinter implements ActionListener, java.awt.event.ActionListener {
    public void actionPerformed(ActionEvent event){
        System.out.println("Ath the tone, the time is "
        + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}