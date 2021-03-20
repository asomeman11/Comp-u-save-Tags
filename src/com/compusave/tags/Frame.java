package com.compusave.tags;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
TODO Add more text fields for the system specs.
TODO Create submit button.
TODO Make submit button do something.
TODO Adjust text field Sizes.
TODO Fix Memory readings.
 */
@SuppressWarnings("all")
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

        panel = new JPanel(null);
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


        //-----------------Model--------------------
        final JLabel ModelL = new JLabel("Model");
        ModelL.setPreferredSize(new Dimension(50,20));
        ModelL.setBounds(15,10,50,20);
        ModelL.setVisible(true);
        panel.add(ModelL);

        Model = new JTextField("Model");
        Model.setToolTipText("System Model");
        Model.setPreferredSize(new Dimension(300,20));
        Model.setBounds(70,10,310,25);
        panel.add(Model);
        Model.setVisible(true);


        //-----------------CPU--------------------
        final JLabel CPUL = new JLabel("CPU");
        CPUL.setPreferredSize(new Dimension(50,20));
        CPUL.setBounds(15,40,50,20);
        panel.add(CPUL);

        CPU = new JTextField("CPU");
        CPU.setToolTipText("CPU");
        //Set the Size of the textfield.
        CPU.setPreferredSize(new Dimension(150,20));
        //Set the location of the text field and the hitbox.
        CPU.setBounds(70,40,120,25);
        panel.add(CPU);
        CPU.setVisible(true);

        //-----------------Memory-----------------
        Mem = new JTextField("Memory");
        Mem.setToolTipText("Memory");
        panel.add(Mem);
        Mem.setVisible(true);

        //-------------------GPU-----------------
        final JLabel GPUL = new JLabel("GPU");
        GPUL.setPreferredSize(new Dimension(50, 20));
        GPUL.setBounds(15,70,50,20);
        panel.add(GPUL);

        GPU = new JTextField("GPU");
        GPU.setToolTipText("GPU");
        GPU.setPreferredSize(new Dimension(150,20));
        GPU.setBounds(70,70,170,25);
        panel.add(GPU);
        GPU.setVisible(true);

        //---------------OS------------------------
        OS = new JTextField("Operating System");
        OS.setToolTipText("Operating System");
        OS.setBounds(70,100,120,25);
        panel.add(OS);
        OS.setVisible(true);

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
    public void windowClosed(WindowEvent e) {Main.Stop();}

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
