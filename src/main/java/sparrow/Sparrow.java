package sparrow;
import java.util.Scanner;
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.nextInt() == 0) { //little tester aw so cute
            Success();
        }else{
            Error();
        }
    }
    public static void Success() {
        Display display = new Display();

        Shell shell = new Shell(display); //new window
        Device device = Display.getCurrent ();
        //Color cuscolor = new Color (device,239,255,232,255); //define cuscolor with a hex code

        Image test = new Image(display, "\\C:\\Users\\seanv\\SCPSAlert\\success.png\\");
        shell.setBackgroundImage(test);

        shell.setText("Alert Successful // Sparrow"); //Set text at top
        shell.setMaximumSize(960,680);
        shell.setMinimumSize(960,680);

        shell.open(); //Start window

        display = Display.getCurrent();

        while (!shell.isDisposed()) { //while shell isn't closed
            if (!display.readAndDispatch()) display.sleep();
        }

        display.dispose(); //end program, save resources
    }
    public static void Error() {
        Display display = new Display();
        Shell shell = new Shell();
        Device device = Display.getCurrent();

        //Color cuscolor = new Color(device, 255,232,232,255);

        Image test = new Image(display, "\\C:\\Users\\seanv\\SCPSAlert\\error.png\\");
        shell.setBackgroundImage(test);

        shell.setText("Error Whilst Sending Alert // Sparrow"); //Set text at top
        shell.setMaximumSize(960,680);
        shell.setMinimumSize(960,680);

        shell.open(); //Start window

        display = Display.getCurrent();

        while (!shell.isDisposed()) { //while shell isn't closed
            if (!display.readAndDispatch()) display.sleep();
        }

        display.dispose(); //end program, save resources
    }
}