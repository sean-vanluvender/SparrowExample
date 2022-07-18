import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Device;

import sparrow.http.SparrowClient;

public class Sparrow {

    public static void main(String[] args) throws IOException {
        String destination = null;
        String token = null;
        String user = System.getProperty("user.name");
        File config = null;
        Scanner configReader = null;
        try {
            config = new File("C:\\Users\\" + user + "\\Documents\\Sparrow\\main.config\\");
            configReader = new Scanner(config);
        }catch(Exception e) {
            error(0);
        }
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
                error(1);
            }
        }catch(Exception e) {
            SparrowClient.createFile(1);
        }
        SparrowClient sparrowClient = new SparrowClient(destination, token);
        if (sparrowClient.raiseAlert()) {
            success();
        } else {
            error(1);
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
        System.out.println("Hello World");

        display = Display.getCurrent();

        while(!shell.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        display.dispose(); //end program, save resources
    }
    public static void error(int i) {
        Display display = new Display();
        Shell shell = new Shell();
        Device device = Display.getCurrent();

        //255,232,232,255

        String user = System.getProperty("user.name");

        Image img = null;

        if(i != 0) {
            img = new Image(display, Sparrow.class.getResourceAsStream("/error.png"));
        }else{
            img = new Image(display, Sparrow.class.getResourceAsStream("/conerror.png"));
        }

        shell.setBackgroundImage(img);

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
        System.exit(0);
    }
}
