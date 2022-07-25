package com.seanvanluvender;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.seanvanluvender.panels.Menu;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Device;

import com.seanvanluvender.http.SparrowClient;

public class Alert {
    public static void main(String [] args) throws IOException {
        System.out.println("This terminal window is essential for Sparrow's operation. Do not close.\n\nSet nerd-stats to true in the configuration file for detailed logs\nof operations in this terminal.");

        String destination = null;
        String token = null;
        Scanner configReader = null;
        File config = null;
        String zenworks = "";
        String nerdstats = "";

        String user = System.getProperty("user.name");
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
                if (!fulldata.startsWith("#")) { //if the full data DOESNT start with #
                    data = fulldata.substring(0, fulldata.indexOf("=")); //DATA is raw config value. FULLDATA is unedited data.
                    if(data.equalsIgnoreCase("destination")) { //If the data values "destination"...
                        data = fulldata.substring(fulldata.indexOf("=") + 1); //Substring raw data; =+1 to the end of the line
                        destination = data; //Copy data value to destination value after substring command
                    }else if(data.equalsIgnoreCase("token")) {
                        data = fulldata.substring(fulldata.indexOf("=") + 1);
                        token = data;
                    }else if(data.equalsIgnoreCase("zenworks")) {
                        data = fulldata.substring(fulldata.indexOf("=") + 1);
                        zenworks = data;
                    }else if(data.equalsIgnoreCase("nerdstats")) {
                        data = fulldata.substring(fulldata.indexOf("=") + 1);
                        nerdstats = data;
                    }

                    if(nerdstats.equalsIgnoreCase("true")) {
                        System.out.println(fulldata); //output full data for debugging
                        data = fulldata.substring(0, fulldata.indexOf("=")); //DATA is raw config value. FULLDATA is unedited data.
                        System.out.println("INFORMATION: " + data); //Output data value. This is the current config option.
                    }
                }
            }
            if(token.equals("")) {
                if(zenworks.equalsIgnoreCase("false")) {
                    Menu menu = new Menu();
                    Menu.main(new String[0]);

                }else{
                    return;
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
        String user = System.getProperty("user.name");
        Display display = new Display();

        Shell shell = new Shell(display); //new window
        Device device = Display.getCurrent ();
        //239,255,232,255

        Image test = new Image(display, Alert.class.getResourceAsStream("C:\\Users\\" + user + "\\Documents\\Sparrow\\resources\\img\\screen\\success.png"));
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
    public static void error(int i) {
        Display display = new Display();
        Shell shell = new Shell();
        Device device = Display.getCurrent();
        //255,232,232,255

        String user = System.getProperty("user.name");

        Image test = new Image(display, Alert.class.getResourceAsStream("/error.png"));

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
        System.exit(0);
    }
}
