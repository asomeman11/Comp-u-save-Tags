package com.compusave.tags;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Frame implements WindowListener {

    public static JFrame frame;
    private static final Dimension size = new Dimension(500,600);
    private static JPanel panel;

    /*
    Setting up the JFrame for startup and defining initial variables
     */
    public static void FrameInit(){
        frame = new JFrame();
        frame.setTitle("Comp-U-Save Tags Client");
        frame.setSize(size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        System.out.println("point 1");
        BuildFrame();
    }
    //Building the JFrame structure.
    private static void BuildFrame(){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField CPU = new JTextField("CPU");
        CPU.setToolTipText("CPU");
        panel.add(CPU);

        JTextField Mem = new JTextField("Memory");
        Mem.setToolTipText("Memory");
        panel.add(Mem);

        System.out.println("point 2");
        frame.setVisible(true);
        System.out.println("point 3");
    }

    //Not Used
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Main.Stop();
    }

    //Not Used
    @Override
    public void windowClosed(WindowEvent e) {

    }

    //Not Used
    @Override
    public void windowIconified(WindowEvent e) {

    }

    //Not Used
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    //Not Used
    @Override
    public void windowActivated(WindowEvent e) {

    }

    //Not Used
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
