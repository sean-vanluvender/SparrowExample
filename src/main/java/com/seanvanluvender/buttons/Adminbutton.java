package com.seanvanluvender.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Adminbutton implements MouseListener {

    JButton admin = new JButton("Administration Sign-in");

    private final Color unselectedColor = Color.getHSBColor(0.325f, 0.29f, 1f); //super light green
    private final Color selectedColor = Color.getHSBColor(0.325f, 1f, 1f); //light green
    private final Color unavailableColor = Color.getHSBColor(0f, 0f, .70f);

    public Adminbutton() {}

    public JButton button() {
        admin = new JButton("Administration Sign-in");

        admin.setBackground(unavailableColor);
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
        admin.setBackground(selectedColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        admin.setBackground(unselectedColor);
    }
}
