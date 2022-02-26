package sparrow;
import java.util.Scanner;
import java.util.Timer;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.*;

public class Sparrow {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start input here.");
        Scanner in = new Scanner(System.in);
        if (in.nextInt() == 0) { //little tester aw so cute
            success();
        }else{
            error();
        }
    }
    public static void success() throws InterruptedException {
        Display display = new Display();

        Shell shell = new Shell(display); //new window
        Device device = Display.getCurrent ();
        //239,255,232,255

        Image test = new Image(display, Sparrow.class.getResourceAsStream("/success.png"));
        shell.setBackgroundImage(test);

        shell.setText("Alert Successful // Sparrow"); //Set text at top
        shell.setMaximumSize(960,680);
        shell.setMinimumSize(960,680);

        shell.open(); //Start window

        display = Display.getCurrent();

        while(!shell.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        display.dispose(); //end program, save resources
    }
    public static void error() throws InterruptedException {
        Display display = new Display();
        Shell shell = new Shell();
        Device device = Display.getCurrent();

        //255,232,232,255

        String user = System.getProperty("user.name");
        Image test = new Image(display, Sparrow.class.getResourceAsStream("/error.png"));

        shell.setBackgroundImage(test);

        shell.setText("Error Whilst Sending Alert // Sparrow"); //Set text at top
        shell.setMaximumSize(960,680);
        shell.setMinimumSize(960,680);

        shell.open(); //Start window

        display = Display.getCurrent();

        while(!shell.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        display.dispose(); //end program, save resources
    }
}