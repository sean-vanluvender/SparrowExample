import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
import org.eclipse.swt.widgets.Text;

import sparrow.http.SparrowClient;

public class Sparrow {

    public static void main(String[] args) throws IOException {
        String destination = null;
        String token = null;
        String user = System.getProperty("user.name");
        File config = new File("C:\\Users\\" + user + "\\Documents\\Sparrow\\main.config\\");
        Scanner configReader = new Scanner(config);
        try {
            while(configReader.hasNext()) {
                String data = null;
                String fulldata = configReader.nextLine(); //get full data
                System.out.println(fulldata); //output full data for debugging
                if (!fulldata.startsWith("#")) { //if the full data DOESNT start with #
                    data = fulldata.substring(0, fulldata.indexOf("=")); //DATA is raw config value. FULLDATA is unedited data.
                    System.out.println("INFORMATION: " + data); //Output data value. This is the current config option.
                    if(data.equalsIgnoreCase("destination")) { //If the data values "destination"...
                        data = fulldata.substring(fulldata.indexOf("=") + 1); //Substring raw data; =+1 to the end of the line
                        destination = data; //Copy data value to destination value after substring command
                    }else if(data.equalsIgnoreCase("token")) {
                        data = fulldata.substring(fulldata.indexOf("=") + 1);
                        token = data;
                    }
                }
            }
            if (destination == null || token == null) {
                SparrowClient.createFile(7);
                error();
            }
        }catch(Exception e) {
            SparrowClient.createFile(1);
        }
        SparrowClient sparrowClient = new SparrowClient(destination, token);
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

    public static void unknownos(String os) {
        Display display = new Display();
        Shell shell = new Shell();
        Device device = Display.getCurrent();

        String user = System.getProperty("user.name");
        Image test = new Image(display, Sparrow.class.getResourceAsStream("/unknownos.png"));

        shell.setBackgroundImage(test);

        Text text = new Text(shell, SWT.NO_BACKGROUND);
        text.setBounds(10, 10, 500, 50);
        text.append("Your Operating System, " + os + ", is not supported on Sparrow.");
        text.setEditable(false);

        shell.setText("Unknown Operating System // Sparrow"); //Set text at top
        shell.setMaximumSize(960,680);
        shell.setMinimumSize(960,680);

        shell.open(); //Start window

        display = Display.getCurrent();

        while(!shell.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        display.dispose(); //end program, save resources
        System.exit(0);
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
