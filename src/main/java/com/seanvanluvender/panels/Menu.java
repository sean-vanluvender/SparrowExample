package com.seanvanluvender.panels;

import com.seanvanluvender.buttons.Adminbutton;
import com.seanvanluvender.buttons.Teacherbutton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Menu {

    private JLabel label;
    private JPanel panel;
    JLabel warn = new JLabel();

    private final Color unselectedColor = Color.getHSBColor(0.325f, 0.29f, 1f); //super light green
    private final Color selectedColor = Color.getHSBColor(0.325f, 0.70f, 1f); //light green

    static Adminbutton admin = new Adminbutton();
    static Teacherbutton teacher = new Teacherbutton();
    static JButton adminbutton = admin.button();
    static JButton teacherbutton = teacher.button();

    public Menu() {}

    public static void main(String [] args) {
        String user = System.getProperty("user.name");
        JFrame frame = new JFrame("Sparrow Sign-in");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();


        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());

        BufferedImage header = null;
        try {
            header = ImageIO.read(new File("C:\\Users\\" + user + "\\Documents\\Sparrow\\resources\\img\\ico\\title.png"));
        }catch(Exception e) {

        }
        JLabel picLabel = new JLabel(new ImageIcon(header));
        GridBagConstraints c0 = new GridBagConstraints();
        c0.fill = GridBagConstraints.CENTER;
        c0.insets = new Insets(30,30,0,30);
        c0.gridy = 0;

        pane.add(picLabel, c0);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.ipady = 50;
        c1.ipadx = 500;
        c1.insets = new Insets(30,30,0,30);
        c1.gridy = 1;
        pane.add(teacherbutton, c1);
        //pane.add(Box.createRigidArea(new Dimension(20,150)));
        JLabel warn = new JLabel();
        warn.setText("ZENworks integration is disabled. Please enter your token into the configuration file and sign in with your license key to enable alerts on this device. ");

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.ipady = 50;      //make this component tall
        c2.ipadx = 500;
        c2.gridy = 2;
        c2.insets = new Insets(30,30,0,30);

        pane.add(adminbutton, c2);
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.ipadx = 0;
        c3.gridy = 3;
        c3.insets = new Insets(10,10,10,10);
        pane.add(warn, c3);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
