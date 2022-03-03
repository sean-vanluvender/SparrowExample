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
import sparrow.http.SparrowClient;

public class Sparrow {

    public static void main(String[] args) {
        SparrowClient sparrowClient = new SparrowClient("http://127.0.0.1:8000/api/v1/alert",
                "CREATE_TOKEN_AND_PUT_IT_HERE");
        if (sparrowClient.raiseAlert()) {
            success();
        } else {
            error();
        }
    }
    public static void success() {
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
    public static void error() {
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