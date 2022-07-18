package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Adminbutton implements MouseListener {

    private final Color unselectedColor = Color.getHSBColor(0.325f, 0.29f, 1f); //super light green
    private final Color selectedColor = Color.getHSBColor(0.325f, 0.70f, 1f); //light green

    public Adminbutton() {}

    public JButton button() {
        JButton admin = new JButton("Administration Sign-in");

        admin.setBackground(unselectedColor);
        admin.setOpaque(true);
        return admin;
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
