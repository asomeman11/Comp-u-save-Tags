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

    private static JTextField Model;
    private static JTextField CPU;
    private static JTextField Mem;
    private static JTextField OS;
    private static JTextField GPU;

    private static void BuildFrame(){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Model = new JTextField("Model");
        Model.setToolTipText("System Model");
        panel.add(Model);
        Model.setVisible(true);

        OS = new JTextField("Operating System");
        OS.setToolTipText("Operating System");
        panel.add(OS);
        OS.setVisible(true);

        CPU = new JTextField("CPU");
        CPU.setToolTipText("CPU");
        CPU.setSize(500,10);
        panel.add(CPU);
        CPU.setVisible(true);

        Mem = new JTextField("Memory");
        Mem.setToolTipText("Memory");
        panel.add(Mem);
        Mem.setVisible(true);

        GPU = new JTextField("GPU");
        GPU.setToolTipText("GPU");
        panel.add(GPU);
        GPU.setVisible(true);

        System.out.println("point 2");
        frame.setVisible(true);
        System.out.println("point 3");
    }

    public static void updateFrame(String os, String cpu, int mem, String gpu){
        try {
            if (os != null) {
                OS.setText(os);
            }else{
                throw new NullPointerException("Unable to load OS declaration to frame");
            }
            if (cpu != null) {
                CPU.setText(cpu);
            }else{
                throw new NullPointerException("Unable to load CPU name to frame");
            }
            if (Integer.toString(mem) != null) {
                Mem.setText(Integer.toString(mem));
            }else{
                throw new NullPointerException("Unable to load Memory info to frame");
            }
            if (gpu != null) {
                GPU.setText(gpu);
            }else{
                throw new NullPointerException("Unable to load GPU name to frame");
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    //Not Used
    @Override
    public void windowOpened(WindowEvent e) {}


    /*
     Class is used to properly handle the JFrame closing event
     and shut down any open files and run some finishing commands.

     @see WindowListener
     @see Main.Stop()
    */
    @Override
    public void windowClosing(WindowEvent e) {
        Main.Stop();
    }

    /*
    This class is function is overrides the window closed event
    in the WindowListener class that is imported.
    @see WindowListener
     */
    @Override
    public void windowClosed(WindowEvent e) {}

    //Not Used
    @Override
    public void windowIconified(WindowEvent e) {}

    //Not Used
    @Override
    public void windowDeiconified(WindowEvent e) {}

    //Not Used
    @Override
    public void windowActivated(WindowEvent e) {}

    //Not Used
    @Override
    public void windowDeactivated(WindowEvent e) {}
}
