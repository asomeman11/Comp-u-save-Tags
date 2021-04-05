package com.compusave.tags;


import com.compusave.tags.Exceptions.InvalidGPUException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
TODO add option for fingerprint, Smartcard and thunderbolt.
TODO Add VRAM spot
TODO Add pro or home option for win OS
TODO backlit keyboard
 */

@SuppressWarnings("all")
public class Frame implements WindowListener {

    public static JFrame frame;
    private static final Dimension size = new Dimension(900,600);
    private static Panel panel;
    private static ImageIcon Icon;

    Frame(){
        FrameInit();
        BuildFrame();
    }

    /*
    Setting up the JFrame for startup and defining initial variables
     */
    public void FrameInit(){
        frame = new JFrame();
        frame.setTitle("Comp-U-Save Ltd. Tags Client");
        frame.setSize(size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Icon = new ImageIcon(Frame.class.getClassLoader().getResource("TagsIcon32x32.png"));
        frame.setIconImage(Icon.getImage());
        panel = new Panel();
        panel.setLayout(null);
        frame.add(panel);
        if (Main.isVerbose()) {System.out.println("Frame Initilized");}
    }

    //Building the JFrame structure.

    private static JTextField Model;
    private static JTextField CPU;
    private static JTextField Mem;
    private static final String[] MemTypes = {"Select","DDR","DDR2","DDR3","DDR3L","DDR4","DDR5","ECC"};
    private static JComboBox<String> MemType;
    private static JTextField OS;
    private static JTextField GPU;
    private static JTextField DriveSize1;
    private static JTextField DriveSize2;
    private static JComboBox<String> DriveType1;
    private static JComboBox<String> DriveType2;
    private static final String[] DriveTypes = {"Select","None","HDD","SSD","M.2","NVMe","mSata","SSHD"};
    private static final String[] DVDtypes = {"None","CD Player","DVD Player","CD Burner",
            "Combo","DVD Burner","Blu-Ray Player","Blu-Ray Combo","Blu-Ray Burner"};
    private static JComboBox<String> diskDrive1;
    private static JComboBox<String> diskDrive2;
    private static JTextField CPUScores;
    private static float CPUScore;
    private static JTextField GPUScores;
    private static float GPUScore;
    private static JTextField Battery;
    private static JComboBox<String> ScreenSize;
    private static final String[] ScreenSizes = {"Size","7\"", "7.9\"", "8\"", "8.9\"", "9\"", "10\"", "10.1\"", "11\"", "11.6\"", "12\"", "12.1\"", "12.5\"",
            "13\"", "13.1\"", "13.3\"", "14\"", "14.1\"", "14.5\"", "15\"", "15.1\"", "15.4\"", "15.5\"", "15.6\"", "16\"", "16.4\"", "17\"",
            "17.1\"", "17.3\"", "18\"", "18.4\"", "18.5\"", "19\"", "19.5\"", "20\"", "20.1\"", "21\"", "21.5\"", "22\"", "23\"", "23.6\"",
            "24\"", "25\"", "26\"", "27\"", "28\"", "Other", "NA"};
    private static JComboBox<String> ScreenType;
    private static final String[] ScreenTypes = {"Type","LCD", "LED", "LCD Touchscreen", "LED Touchscreen"};
    private static JComboBox<String> ScreenRefRate;
    private static final String[] RefRates = {"60Hz","75Hz","144Hz","240Hz"};
    private static JTextField Price;
    private static final String[] conditons = {"Refurbished","New"};
    private static JComboBox<String> Condition;
    private static JLabel updating;
    private static boolean Updating = true;

    private void BuildFrame(){
        //Defines the height for all of the componets.
        final int Height = 25;
        //Defines the Y location for the model info
        final int ModelY = 10;
        //Defines the Y location for the cpu info
        final int CPUY = 40;
        //Defines the Y location for memory info
        final int MemY = 70;
        //Defines the Y location for the first HDD/SSD
        final int D1Y = 100;
        //Defines the Y location for the seccond HDD/SSD
        final int D2Y = 130;
        //Defines the Y location for gpu info
        final int GPUY = 160;
        //Defines the Y location for the optical media
        final int DVDY = 190;
        //Defines the Y location for os info line
        final int OSY = 220;
        //Defines the Y location for the scores line
        final int ScoY = 250;
        //Defines the Y location for the battery line
        final int BatY = 280;
        //Defines the Y location for the screen line
        final int ScrY = 310;
        //Defines the Y location for the price line
        final int PrY = 340;
        //Defines the Y location for the conditions line
        final int ConY = 370;
        //Defines the Y location for the warranty line
        final int WarY = 400;
        //Defines the Y location for the notes line
        final int NotY = 430;
        if(Main.isVerbose()){System.out.println("Building frame and adding componets.");}

        //-----------------Model--------------------
        final JLabel ModelL = new JLabel("Model");
        ModelL.setBounds(15,ModelY,50,Height);
        ModelL.setVisible(true);
        panel.add(ModelL);

        Model = new JTextField("Model");
        Model.setToolTipText("System Model");
        Model.setBounds(70,ModelY,230,Height);
        panel.add(Model);
        Model.setVisible(true);

        //-----------------CPU--------------------
        final JLabel CPUL = new JLabel("CPU");
        CPUL.setBounds(15,CPUY,50,Height);
        panel.add(CPUL);

        CPU = new JTextField("CPU");
        CPU.setToolTipText("CPU");
        //Set the location of the text field and the hitbox.
        CPU.setBounds(70,CPUY,230,Height);
        panel.add(CPU);
        CPU.setVisible(true);

        //-----------------Memory-----------------
        JLabel MemL = new JLabel("Memory");
        MemL.setBounds(15,MemY,50,Height);
        panel.add(MemL);
        MemL.setVisible(true);

        Mem = new JTextField("Size");
        Mem.setToolTipText("Size of installed memory");
        Mem.setBounds(70,MemY,110,Height);
        panel.add(Mem);
        Mem.setVisible(true);

        JLabel MemTypL = new JLabel("Type:");
        MemTypL.setBounds(190,MemY,50,Height);
        panel.add(MemTypL);
        MemTypL.setVisible(true);

        MemType = new JComboBox<String>(MemTypes);
        MemType.setBounds(234,MemY,65,Height);
        panel.add(MemType);
        MemType.setVisible(true);

        //--------------------Drive 1--------------
        JLabel Drive1L = new JLabel("Drive 1");
        Drive1L.setBounds(15,D1Y,50,Height);
        panel.add(Drive1L);
        Drive1L.setVisible(true);

        DriveSize1 = new JTextField("Size");
        DriveSize1.setToolTipText("Drive 1 Size");
        DriveSize1.setBounds(70,D1Y,110,Height);
        panel.add(DriveSize1);
        DriveSize1.setVisible(true);

        JLabel DriveType1L = new JLabel("Type:");
        DriveType1L.setBounds(190,D1Y,70,Height);
        panel.add(DriveType1L);
        DriveType1L.setVisible(true);

        DriveType1 = new JComboBox<String>(DriveTypes);
        DriveType1.setBounds(234,D1Y,65,Height);
        panel.add(DriveType1);
        DriveType1.setVisible(true);

        //--------------------Drive 2--------------
        JLabel Drive2L = new JLabel("Drive 2");
        Drive2L.setBounds(15,D2Y,50,Height);
        panel.add(Drive2L);
        Drive2L.setVisible(true);

        DriveSize2 = new JTextField("Size");
        DriveSize2.setToolTipText("Drive 2 Size");
        DriveSize2.setBounds(70,D2Y,110,Height);
        DriveSize2.setEditable(false);
        panel.add(DriveSize2);
        DriveSize2.setVisible(true);

        JLabel DriveType2L = new JLabel("Type:");
        DriveType2L.setBounds(190,D2Y,70,Height);
        panel.add(DriveType2L);
        DriveType2L.setVisible(true);

        DriveType2 = new JComboBox<String>(DriveTypes);
        DriveType2.setBounds(234,D2Y,65,Height);
        DriveType2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(DriveType2.getSelectedItem().toString());
                if (!(DriveType2.getSelectedItem().toString().toUpperCase() == "NONE") || !(DriveType2.getSelectedItem().toString().toUpperCase() == "Select")){
                    DriveSize2.setEditable(true);
                }
                if ((DriveType2.getSelectedItem().toString().toUpperCase() == "NONE") || !(DriveType2.getSelectedItem().toString().toUpperCase() == "Select")){
                    DriveSize2.setEditable(false);
                }
            }
        });
        panel.add(DriveType2);
        DriveType2.setVisible(true);

        //-------------------GPU-----------------
        final JLabel GPUL = new JLabel("GPU");
        GPUL.setBounds(15,GPUY,50,Height);
        panel.add(GPUL);
        GPUL.setVisible(true);

        GPU = new JTextField("GPU");
        GPU.setToolTipText("GPU");
        GPU.setBounds(70,GPUY,230,Height);
        panel.add(GPU);
        GPU.setVisible(true);

        //--------------------Optical----------------
        JLabel opticalL = new JLabel("Optical");
        opticalL.setBounds(15,DVDY,50,Height);
        panel.add(opticalL);
        opticalL.setVisible(true);

        diskDrive1 = new JComboBox<>(DVDtypes);
        diskDrive1.setBounds(70,DVDY,110,Height);
        panel.add(diskDrive1);
        diskDrive1.setVisible(true);

        diskDrive2 = new JComboBox<>(DVDtypes);
        diskDrive2.setBounds(190,DVDY,110,Height);
        panel.add(diskDrive2);
        diskDrive2.setVisible(true);

        //---------------OS------------------------
        JLabel OSL = new JLabel("OS");
        OSL.setBounds(15,OSY,50,Height);
        panel.add(OSL);
        OSL.setVisible(true);

        OS = new JTextField("Operating System");
        OS.setToolTipText("Operating System");
        OS.setBounds(70,OSY,230,Height);
        panel.add(OS);
        OS.setVisible(true);

        //--------------------Scores------------------
        JLabel Scoresl = new JLabel("Scores");
        Scoresl.setBounds(15,ScoY,50,Height);
        panel.add(Scoresl);
        Scoresl.setVisible(true);

        JLabel ScoreCPUl = new JLabel("CPU:");
        ScoreCPUl.setBounds(69,ScoY,30,Height);
        panel.add(ScoreCPUl);
        ScoreCPUl.setVisible(true);

        CPUScores = new JTextField();
        CPUScores.setBounds(103,ScoY,77,Height);
        panel.add(CPUScores);
        CPUScores.setVisible(true);

        JLabel ScoreGPU = new JLabel("GPU:");
        ScoreGPU.setBounds(185,ScoY,30,Height);
        panel.add(ScoreGPU);
        ScoreGPU.setVisible(true);

        GPUScores = new JTextField();
        GPUScores.setBounds(220,ScoY,80,Height);
        panel.add(GPUScores);
        GPUScores.setVisible(true);

        //--------------------Battery----------------
        JLabel Batteryl = new JLabel("Battery");
        Batteryl.setBounds(15, BatY, 50,Height);
        panel.add(Batteryl);
        Batteryl.setVisible(true);

        Battery = new JTextField();
        Battery.setBounds(70, BatY, 230, Height);
        panel.add(Battery);
        Battery.setVisible(true);

        //--------------------Screen------------------
        JLabel Screenl = new JLabel("Screen");
        Screenl.setBounds(15,ScrY, 50,Height);
        panel.add(Screenl);

        ScreenSize = new JComboBox<>(ScreenSizes);
        ScreenSize.setBounds(70, ScrY, 64,Height);
        panel.add(ScreenSize);
        ScreenSize.setVisible(true);

        ScreenType = new JComboBox<>(ScreenTypes);
        ScreenType.setBounds(135,ScrY,100,Height);
        panel.add(ScreenType);
        ScreenType.setVisible(true);

        ScreenRefRate = new JComboBox<>(RefRates);
        ScreenRefRate.setBounds(236,ScrY,63,Height);
        panel.add(ScreenRefRate);
        ScreenRefRate.setVisible(true);

        //--------------------Price-------------------
        JLabel Pricel = new JLabel("Price");
        Pricel.setBounds(15,PrY,50,Height);
        panel.add(Pricel);
        Pricel.setVisible(true);

        Price = new JTextField("Price");
        Price.setBounds(70,PrY,230,Height);
        panel.add(Price);
        Price.setVisible(true);

        //---------------Condition------------------
        JLabel Conditionl = new JLabel("Condition");
        Conditionl.setBounds(10,ConY,60,Height);
        panel.add(Conditionl);
        Conditionl.setVisible(true);

        Condition = new JComboBox<>(conditons);
        Condition.setBounds(70,ConY,230,Height);
        panel.add(Condition);
        Condition.setVisible(true);

        //--------------------Status------------------
        updating = new JLabel("Retrieving System Info. Please wait.");
        updating.setBounds(300,500,400,Height);
        panel.add(updating);
        updating.setVisible(Updating);

        if(Main.isVerbose()){System.out.println("Componets added to frame");}
        frame.setVisible(true);
        if(Main.isVerbose()){System.out.println("Frame set to visible");}

    }


    /*
    This class is called by the <Code>Sysinfo</Code> class.
    When this is called, it will pass through the os,
    CPU and GPU name as well as the amount of system memory
    @Peramiters String os, String cpu, int mem, String gpu
    @See com.compusave.tags.Sysinfo
     */
    public static void updateFrame(String os, String cpu, int mem, String gpu){
        if(Main.isVerbose()){System.out.println("System Info retrived, updating componets.");}
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
            if (Integer.toString((int)mem) != null) {
                Mem.setText(Integer.toString(mem) + " Gb");
            }else{
                throw new NullPointerException("Unable to load Memory info to frame");
            }
            if (gpu != null) {
                GPU.setText(gpu);
            }else{
                throw new InvalidGPUException("Invalid GPU detected. If this system has integrated graphics, you may disregard this error." +
                " If not, please contact Gerry and let him know you broke his damn program. ");
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (InvalidGPUException e){
            System.err.println(e.getMessage());
        }
        System.out.println("Componets successfully updated. Please check tag for accuracy.");
        updating.setText("Update complete.");
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
