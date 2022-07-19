import buttons.Adminbutton;
import buttons.Teacherbutton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    private final Color unselectedColor = Color.getHSBColor(0.325f, 0.29f, 1f); //super light green
    private final Color selectedColor = Color.getHSBColor(0.325f, 0.70f, 1f); //light green

    final static boolean RIGHT_TO_LEFT = false;

    static Adminbutton admin = new Adminbutton();
    static Teacherbutton teacher = new Teacherbutton();
    static JButton adminbutton = admin.button();
    static JButton teacherbutton = teacher.button();
    public void addComponentsToPane(Container pane) throws IOException {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new GridBagLayout());

        BufferedImage myPicture = ImageIO.read(new File("src/main/resources/j.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        pane.add(picLabel);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.ipady = 50;
        c1.ipadx = 500;
        c1.insets = new Insets(30,30,0,30);
        c1.gridy = 1;
        pane.add(teacherbutton, c1);
        //pane.add(Box.createRigidArea(new Dimension(20,150)));

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.ipady = 50;      //make this component tall
        c2.ipadx = 500;
        c2.gridy = 2;
        c2.insets = new Insets(30,30,30,30);

        pane.add(adminbutton, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.FIRST_LINE_END;
        c3.ipady = 50;      //make this component tall
        c3.ipadx = 250;
        c3.gridy = 0;
        c3.insets = new Insets(30,30,30,30);

        JLabel warn = new JLabel();

    }

    public GUI() throws IOException {
        JFrame frame = new JFrame("Sparrow Sign-in");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new GUI();
    }
}
