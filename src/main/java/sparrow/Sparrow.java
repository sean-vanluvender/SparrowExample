package sparrow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Sparrow {

    public static void main(String[] args) {
        Display display = new Display ();
        Shell shell = new Shell(display);
        shell.setText("Snippet 1");
        shell.open ();
        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }

}
