import buttons.Adminbutton;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton teacher;

    private final Color unselectedColor = Color.getHSBColor(0.325f, 0.29f, 1f); //super light green
    private final Color selectedColor = Color.getHSBColor(0.325f, 0.70f, 1f); //light green

    public GUI() {

        Adminbutton admin = new Adminbutton();

        teacher = new JButton("Teacher Sign-in");
        frame = new JFrame();
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        admin.button().setSize(new Dimension(200, 200));

        panel.add(admin.button());
        frame.add(admin.button());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sparrow Sign-in");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }
}
