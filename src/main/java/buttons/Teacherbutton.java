package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Teacherbutton implements MouseListener {

    JButton teacher = new JButton("Teacher Sign-in");

    private final Color unselectedColor = Color.getHSBColor(0.325f, 0.29f, 1f); //super light green
    private final Color selectedColor = Color.getHSBColor(0.325f, 0.70f, 1f); //light green

    public Teacherbutton() {}

    public JButton button() {
        teacher.setBackground(unselectedColor);
        teacher.setOpaque(true);
        return teacher;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
