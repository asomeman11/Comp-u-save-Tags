package com.compusave.tags;


import com.compusave.tags.Exceptions.InvalidGPUException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/*
TODO Fix windows closing operation to properly end program execution.
TODO Add more text fields for the system specs.
TODO Make submit button do something.
TODO Adjust text field Sizes.
TODO Get Mac SN
TODO Add VRAM spot
TODO Add pro or home option for win OS
 */


/*
The Frame class is the basic setup of the JFrame that will be used to display all information and text fields
This will define how the user is able to interact with the tags frame and the subsequent component displayed on it.
@see JFrame
@see WindowListener
@See JPanel
 */
@SuppressWarnings("all")
public class Frame extends JFrame implements WindowListener {

    public static JFrame frame;
    private static final Dimension size = new Dimension(730,550);
    private static Panel panel;
    private static ImageIcon Icon;

    /*
    This is the main static call for the Frame class. This will be called by the Main class
    @see Main.class
     */
    Frame(){
        FrameInit();
        BuildFrameSpecs();
        BuildFrameChecks();
        BuildFrameFeatures();
        panel.paint(panel.getGraphics());
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
        addWindowListener(this);
        Icon = new ImageIcon(Objects.requireNonNull(Frame.class.getClassLoader().getResource("TagsIcon32x32.png")));
        frame.setIconImage(Icon.getImage());
        panel = new Panel();
        panel.setLayout(null);
        frame.add(panel);
        panel.paint(panel.getGraphics());
        if (Main.isVerbose()) {System.out.println("Frame Initialized");}
    }

    /*
    Building the JFrame structure and components variables.
     */
    public static JTextField Model;
    public static JTextField CPU;
    public static JTextField Mem;
    private static final String[] MemTypes = {"Select","DDR","DDR2","DDR3","DDR3L","DDR4","DDR5","ECC"};
    public static JComboBox<String> MemType;
    public static JTextField OS;
    public static JTextField GPU;
    public static JTextField DriveSize1;
    public static JTextField DriveSize2;
    public static JComboBox<String> DriveType1;
    public static JComboBox<String> DriveType2;
    private static final String[] DriveTypes = {"Select","None","HDD","SSD","M.2","NVMe","mSata","SSHD"};
    private static final String[] DVDtypes = {"None","CD Player","DVD Player","CD Burner",
            "Combo","DVD Burner","Blu-Ray Player","Blu-Ray Combo","Blu-Ray Burner"};
    public static JComboBox<String> diskDrive1;
    public static JComboBox<String> diskDrive2;
    public static JTextField CPUScores;
    public static float CPUScore;
    public static JTextField GPUScores;
    public static float GPUScore;
    public static JTextField Battery;
    public static JComboBox<String> ScreenSize;
    private static final String[] ScreenSizes = {"Size","7\"", "7.9\"", "8\"", "8.9\"", "9\"", "10\"", "10.1\"", "11\"", "11.6\"", "12\"", "12.1\"", "12.5\"",
            "13\"", "13.1\"", "13.3\"", "14\"", "14.1\"", "14.5\"", "15\"", "15.1\"", "15.4\"", "15.5\"", "15.6\"", "16\"", "16.4\"", "17\"",
            "17.1\"", "17.3\"", "18\"", "18.4\"", "18.5\"", "19\"", "19.5\"", "20\"", "20.1\"", "21\"", "21.5\"", "22\"", "23\"", "23.6\"",
            "24\"", "25\"", "26\"", "27\"", "28\"", "Other", "NA"};
    public static JComboBox<String> ScreenType;
    private static final String[] ScreenTypes = {"Type","LCD", "LED", "LCD Touchscreen", "LED Touchscreen"};
    public static JComboBox<String> ScreenRefRate;
    private static final String[] RefRates = {"60Hz","75Hz","120Hz","144Hz","240Hz"};
    public static JTextField Price;
    private static final String[] conditions = {"Refurbished","New"};
    public static JComboBox<String> Condition;
    private static final String[] lawars = {"Labor", "90 Days", "1 Year", "2 Years", "3 Years"};
    private static final String[] parwars = {"Parts", "90 Days", "1 Year", "2 Years", "3 Years"};
    public static JComboBox<String> lawar;
    public static JComboBox<String> parwar;
    public static JTextField Notes;
    private static JLabel updating;
    private static boolean Updating = true;

    /*
    Adding the Specs information and text fields to the JFrame.
     */
    private void BuildFrameSpecs(){
        //Defines the height for all of the components.
        final int Height = 25;
        //Defines the Y location for the model info
        final int ModelY = 10;
        //Defines the Y location for the cpu info
        final int CPUY = 40;
        //Defines the Y location for memory info
        final int MemY = 70;
        //Defines the Y location for the first HDD/SSD
        final int D1Y = 100;
        //Defines the Y location for the second HDD/SSD
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
        if(Main.isVerbose()){System.out.println("Building frame and adding components.");}

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
        DriveType2.addItemListener(e -> System.out.println(e.getItem().toString()));
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

        Condition = new JComboBox<>(conditions);
        Condition.setBounds(70,ConY,230,Height);
        panel.add(Condition);
        Condition.setVisible(true);

        //---------------Warranty----------------------
        JLabel war = new JLabel("Warranty");
        war.setBounds(10,WarY,60,Height);
        panel.add(war);
        war.setVisible(true);

        parwar = new JComboBox<>(parwars);
        parwar.setBounds(70,WarY,110,Height);
        panel.add(parwar);
        parwar.setVisible(true);

        lawar = new JComboBox<>(lawars);
        lawar.setBounds(190,WarY,110,Height);
        panel.add(lawar);
        lawar.setVisible(true);

        //--------------------Notes-------------------
        JLabel Notesl = new JLabel("Notes");
        Notesl.setBounds(15,NotY,50,Height);
        panel.add(Notesl);
        Notesl.setVisible(true);

        Notes = new JTextField("Notes");
        Notes.setBounds(70, NotY,230,Height);
        panel.add(Notes);
        Notes.setVisible(true);

        //--------------------Status------------------
        updating = new JLabel("Retrieving System Info. Please wait.");
        updating.setBounds(300,475,300,Height);
        panel.add(updating);
        updating.setVisible(Updating);

        if(Main.isVerbose()){System.out.println("Components added to frame");}
        frame.setVisible(true);
        if(Main.isVerbose()){System.out.println("Frame set to visible");}

    }

    /*
    Defining variables for the double check boxes
     */
    public static JCheckBox SKU;
    public static JCheckBox HDD;
    public static JCheckBox MEM;
    public static JCheckBox DRI;
    public static JCheckBox UPD;
    public static JCheckBox FIN;
    public static JCheckBox ACT;
    public static JCheckBox CAP;
    public static JCheckBox WIP;
    public static JCheckBox BLO;
    public static JCheckBox DVD;
    public static JCheckBox BAT;
    public static JCheckBox VRM;
    public static String[] Techs = {"Tom", "Erik", "Gerry", "Dave"};
    public static final JLabel TechRefL = new JLabel("Refurbing Tech:");
    public static JComboBox<String> TechRef;
    public static JLabel TechSubL;
    public static JComboBox<String> TechSub;
    public static final JLabel PWL = new JLabel("Password");
    public static JButton passpull;
    public static JButton Submit;
    public static JButton Debug;

    /*
        Defining the checkboxes
     */
    private void BuildFrameChecks(){

        final int ChW = 115;
        final int ChH = 20;
        final int ChX = 310;

        BAT = new JCheckBox("Battery Test");
        BAT.setBounds(ChX,10, ChW, ChH);
        panel.add(BAT);
        BAT.setVisible(true);

        SKU = new JCheckBox("Has SKU");
        SKU.setBounds(ChX, 35, ChW, ChH);
        panel.add(SKU);
        SKU.setVisible(true);

        HDD = new JCheckBox("HDD Test");
        HDD.setBounds(ChX, 60, ChW, ChH);
        panel.add(HDD);
        HDD.setVisible(true);

        MEM = new JCheckBox("Mem Test");
        MEM.setBounds(ChX,85,ChW,ChH);
        panel.add(MEM);
        MEM.setVisible(true);

        DRI = new JCheckBox("Drivers");
        DRI.setBounds(ChX,110,ChW,ChH);
        panel.add(DRI);
        DRI.setVisible(true);

        UPD = new JCheckBox("Updates");
        UPD.setBounds(ChX,135,ChW,ChH);
        panel.add(UPD);
        UPD.setVisible(true);

        FIN = new JCheckBox("Finisher");
        FIN.setBounds(ChX,160,ChW,ChH);
        panel.add(FIN);
        FIN.setVisible(true);

        ACT = new JCheckBox("Activated");
        ACT.setBounds(ChX,185,ChW,ChH);
        panel.add(ACT);
        ACT.setVisible(true);

        CAP = new JCheckBox("Capacitors");
        CAP.setBounds(ChX,210,ChW,ChH);
        panel.add(CAP);
        CAP.setVisible(true);

        WIP = new JCheckBox("Wipe Down");
        WIP.setBounds(ChX,235,ChW,ChH);
        panel.add(WIP);
        WIP.setVisible(true);

        BLO = new JCheckBox("Blow Out");
        BLO.setBounds(ChX,260,ChW,ChH);
        panel.add(BLO);
        BLO.setVisible(true);

        DVD = new JCheckBox("Check DVD");
        DVD.setBounds(ChX,285,ChW,ChH);
        panel.add(DVD);
        DVD.setVisible(true);

        BAT = new JCheckBox("Battery Test");
        BAT.setBounds(ChX,310,ChW,ChH);
        panel.add(BAT);
        BAT.setVisible(true);

        VRM = new JCheckBox("VRAM Checked");
        VRM.setBounds(ChX,335,ChW,ChH);
        panel.add(VRM);
        VRM.setVisible(true);

        //------------------Subbiting tags-----------------

        TechRefL.setBounds(470, 270,120,25);
        panel.add(TechRefL);
        TechRefL.setVisible(true);

        TechRef = new JComboBox<>(Techs);
        TechRef.setBounds(590,270,70,25);
        TechRef.addActionListener(e -> System.out.println(TechRef.getSelectedItem()));
        panel.add(TechRef);
        TechRef.setVisible(true);





        //---------------Pull Passmark scores--------------
        passpull = new JButton();
        passpull.setBounds(470,395,225,25);
        passpull.setText("Pull Passmark Scores");
        panel.add(passpull);


        //----------------------Submit--------------------
        Submit = new JButton();
        Submit.setBounds(470,425,105,30);
        Submit.setText("Submit");
        panel.add(Submit);
        Submit.addActionListener(e -> {
            Object[] Sysinfo = new Object[] {Model.getText(),CPU.getText(),Mem.getText() + " " + MemType.getSelectedItem(),GPU.getText(),OS.getText(),
                    DriveSize1.getText() + " " + DriveType1.getSelectedItem(),DriveSize2.getText() + " " + DriveType2.getSelectedItem(),diskDrive1.getSelectedItem(),diskDrive2.getSelectedItem(),
                    CPUScores.getText(),GPUScores.getText(),Battery.getText(),ScreenSize.getSelectedItem(), ScreenType.getSelectedItem(), ScreenRefRate.getSelectedItem(),
                    Price.getText(),Condition.getSelectedItem(),lawar.getSelectedItem(),parwar.getSelectedItem(),Notes.getText()};
            new Submit(Sysinfo);
            updating.setText("Tag Generated. You may now close the client.");
        });
        Submit.setVisible(true);

        //------------------------Debug----------------------
        Debug = new JButton("Debug");
        Debug.setBounds(590,425,105,30);
        panel.add(Debug);
        Debug.addActionListener(e -> System.out.println("Debug button test"));
        Debug.setVisible(true);
    }

    //Ports
    public JCheckBox usbtype3;
    public JCheckBox usbtype2;
    public JCheckBox usbtypeC;
    public JCheckBox thunder;
    public JCheckBox cardread;
    public JCheckBox firewire;
    public JCheckBox NIC;
    public JCheckBox hdmi;
    public JCheckBox dp;

    //Features
    public JCheckBox wifi;
    public JCheckBox bluetooth;
    //public JCheckBox smartcard; //this probably wont be a selling point so it is most likely not gonna make it to the full version.
    public JCheckBox fingerprint;
    public JCheckBox blkeys;
    public JCheckBox webcam;



    public void BuildFrameFeatures(){

        int w = 100;
        int x1 = 470; //x location for Ports
        int x2 = 600; //x location for Features

        //Ports row

        JLabel PortsL = new JLabel("Ports:");
        PortsL.setBounds(x1,10,w,20);
        panel.add(PortsL);
        PortsL.setVisible(true);

        usbtype2 = new JCheckBox("USB 2");
        usbtype2.setBounds(x1,30,w,15);
        panel.add(usbtype2);

        usbtype3 = new JCheckBox("USB 3");
        usbtype3.setBounds(x1,50,w,15);
        panel.add(usbtype3);

        usbtypeC = new JCheckBox("USB C");
        usbtypeC.setBounds(x1,70,w,15);
        panel.add(usbtypeC);

        cardread = new JCheckBox("Card Reader");
        cardread.setBounds(x1,90,w,15);
        panel.add(cardread);

        firewire = new JCheckBox("Firewire");
        firewire.setBounds(x1,110,w,15);
        panel.add(firewire);

        NIC = new JCheckBox("NIC");
        NIC.setBounds(x1,130,w,15);
        panel.add(NIC);

        thunder = new JCheckBox("Thunderbolt");
        thunder.setBounds(x1,150,w,15);
        panel.add(thunder);

        //Features row

        JLabel FeaturesL = new JLabel("Features:");
        FeaturesL.setBounds(x2,10,w,20);
        panel.add(FeaturesL);

        wifi = new JCheckBox("WIFI");
        wifi.setBounds(x2,30,w,15);
        panel.add(wifi);

        bluetooth = new JCheckBox("Bluetooth");
        bluetooth.setBounds(x2, 50, w, 15);
        panel.add(bluetooth);

        fingerprint = new JCheckBox("Fingerprint");
        fingerprint.setBounds(x2, 70, w, 15);
        panel.add(fingerprint);

        webcam = new JCheckBox("Webcam");
        webcam.setBounds(x2,90,w,15);
        panel.add(webcam);


        System.out.println("Test");
    }


    /*
    This class is called by the <Code>Sysinfo</Code> class.
    When this is called, it will pass through the os,
    CPU and GPU name as well as the amount of system memory
    @Parameters String os, String cpu, int mem, String gpu
    @See com.compusave.tags.Sysinfo
     */
    public static void updateFrame(String os, String cpu, int mem, String gpu){
        if(Main.isVerbose()){System.out.println("System Info retrieved, updating components.");}
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
                Mem.setText(mem + " Gb");
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
        System.out.println("Components successfully updated. Please check tag for accuracy.");
        updating.setText("Update complete.");
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    /*
        //Not Used
        @Override
        public void windowOpened(WindowEvent e) {}


         Class is used to properly handle the JFrame closing event
         and shut down any open files and run some finishing commands.

         WARNING! This class is currently non functional.

         @see WindowListener
         @see Main.Stop()
    */
    @Override
    public void windowClosing(WindowEvent e) {
        //Main.Stop();
    }

/*
    This class is function is overrides the window closed event
    in the WindowListener class that is imported.
    @see WindowListener
*/
    @Override
    public void windowClosed(WindowEvent e) {//Main.Stop();
        }

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
