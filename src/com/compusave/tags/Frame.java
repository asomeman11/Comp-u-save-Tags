package com.compusave.tags;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
TODO Fix windows closing operation to properly end profram execution.
TODO Add more text fields for the system specs.
TODO Create submit button.
TODO Make submit button do something.
TODO Adjust text field Sizes.
TODO Fix memory readings.
TODO Get Mac SN
 */
@SuppressWarnings("all")
public class Frame implements WindowListener {

    public static JFrame frame;
    private static final Dimension size = new Dimension(900,600);
    private static JPanel panel;
    private static ImageIcon Icon;

    /*
    Setting up the JFrame for startup and defining initial variables
     */
    public static void FrameInit(){
        frame = new JFrame();
        frame.setTitle("Comp-U-Save Tags Client");
        frame.setSize(size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Icon = new ImageIcon(Frame.class.getClassLoader().getResource("TagsIcon32x32.png"));
        frame.setIconImage(Icon.getImage());

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
    private static JTextField DriveSize1;
    private static JTextField DriveSize2;
    private static JComboBox<String> DriveType1;
    private static JComboBox<String> DriveType2;
    private static String[] DriveTypes = {"HDD", "SSD", "M.2"};

    private static void BuildFrame(){


        //-----------------Model--------------------
        final JLabel ModelL = new JLabel("Model");
        ModelL.setBounds(15,10,50,25);
        ModelL.setVisible(true);
        panel.add(ModelL);

        Model = new JTextField("Model");
        Model.setToolTipText("System Model");
        Model.setBounds(70,10,340,25);
        panel.add(Model);
        Model.setVisible(true);


        //-----------------CPU--------------------
        final JLabel CPUL = new JLabel("CPU");
        CPUL.setPreferredSize(new Dimension(50,25));
        CPUL.setBounds(15,40,50,20);
        panel.add(CPUL);

        CPU = new JTextField("CPU");
        CPU.setToolTipText("CPU");
        //Set the location of the text field and the hitbox.
        CPU.setBounds(70,40,170,25);
        panel.add(CPU);
        CPU.setVisible(true);

        //-----------------Memory-----------------
        Mem = new JTextField("Memory");
        Mem.setToolTipText("Memory");
        panel.add(Mem);
        Mem.setVisible(true);

        //-------------------GPU-----------------
        final JLabel GPUL = new JLabel("GPU");
        GPUL.setPreferredSize(new Dimension(50, 25));
        GPUL.setBounds(15,70,50,20);
        panel.add(GPUL);

        GPU = new JTextField("GPU");
        GPU.setToolTipText("GPU");
        GPU.setBounds(70,70,170,25);
        panel.add(GPU);
        GPU.setVisible(true);

        //---------------OS------------------------
        JLabel OSL = new JLabel("OS");
        OSL.setBounds(15,100,50,25);
        panel.add(OSL);
        OSL.setVisible(true);

        OS = new JTextField("Operating System");
        OS.setToolTipText("Operating System");
        OS.setBounds(70,100,170,25);
        panel.add(OS);
        OS.setVisible(true);

        //--------------------Drive 1--------------
        JLabel Drive1L = new JLabel("Drive 1");
        Drive1L.setBounds(15,130,50,25);
        panel.add(Drive1L);
        Drive1L.setVisible(true);

        DriveSize1 = new JTextField("Size");
        DriveSize1.setToolTipText("Drive 1 Size");
        DriveSize1.setBounds(70,130,70,25);
        panel.add(DriveSize1);
        DriveSize1.setVisible(true);

        DriveType1 = new JComboBox<String>(DriveTypes);
        DriveType1.setBounds(170,130,60,25);
        panel.add(DriveType1);
        DriveType1.setVisible(true);

        //--------------------Drive 2--------------
        JLabel Drive2L = new JLabel("Drive 2");
        Drive2L.setBounds(15,160,50,25);
        panel.add(Drive2L);
        Drive2L.setVisible(true);

        DriveSize2 = new JTextField("Size");
        DriveSize2.setToolTipText("Drive 2 Size");
        DriveSize2.setBounds(70,160,70,25);
        panel.add(DriveSize2);
        DriveSize2.setVisible(true);

        DriveType2 = new JComboBox<String>(DriveTypes);
        DriveType2.setBounds(170,160,60,25);
        panel.add(DriveType2);
        DriveType2.setVisible(true);


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
                throw new NullPointerException("Unable to load GPU name to frame. Please add it manually to the tag.");
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

     WARRNING! This class is currently non functional.

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
