package com.compusave.tags;


import com.compusave.tags.Exceptions.InvalidGPUException;

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
TODO add option for fingerprint, Smartcard and thunderbolt.
TODO Add VRAM spot
TODO Add pro or home option for win OS
TODO backlit keyboard
 */

@SuppressWarnings("all")
public class Frame extends JPanel implements WindowListener {

    public static JFrame frame;
    private static final Dimension size = new Dimension(900,600);
    private static Panel panel;
    private static ImageIcon Icon;

    Frame(){
        FrameInit();
    }

    /*
    Setting up the JFrame for startup and defining initial variables
     */
    public void FrameInit(){
        frame = new JFrame();
        frame.setTitle("Comp-U-Save Ltd. Tags Client");
        frame.setSize(size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Icon = new ImageIcon(Frame.class.getClassLoader().getResource("TagsIcon32x32.png"));
        frame.setIconImage(Icon.getImage());
        panel = new Panel();
        panel.setLayout(null);
        frame.add(panel);
        if (Main.isVerbose()) {System.out.println("Frame Initilized");}
        BuildFrame();
    }

    //Building the JFrame structure.

    private static JTextField Model;
    private static JTextField CPU;
    private static JTextField Mem;
    private static String[] MemTypes = {"DDR","DDR2","DDR3","DDR4","DDR5","ECC"};
    private static JComboBox<String> MemType;
    private static JTextField OS;
    private static JTextField GPU;
    private static JTextField VRAM;
    private static JTextField DriveSize1;
    private static JTextField DriveSize2;
    private static JComboBox<String> DriveType1;
    private static JComboBox<String> DriveType2;
    private static String[] DriveTypes = {"None", "HDD", "SSD", "M.2"};
    private static JLabel updating;
    private static boolean Updating = true;
    private static Graphics g;

    private void BuildFrame(){

        if(Main.isVerbose()){System.out.println("Building frame and adding componets.");}

        /*
        g = new Graphics() {
            @Override
            public Graphics create() {
                return g;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {

            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        };
        g.setPaintMode();
         */

        //-----------------Model--------------------
        int ModelY = 10;
        final JLabel ModelL = new JLabel("Model");
        ModelL.setBounds(15,ModelY,50,25);
        ModelL.setVisible(true);
        panel.add(ModelL);

        Model = new JTextField("Model");
        Model.setToolTipText("System Model");
        Model.setBounds(70,ModelY,230,25);
        panel.add(Model);
        Model.setVisible(true);


        //-----------------CPU--------------------
        int CPUY = 40;
        final JLabel CPUL = new JLabel("CPU");
        CPUL.setBounds(15,CPUY,50,25);
        panel.add(CPUL);

        CPU = new JTextField("CPU");
        CPU.setToolTipText("CPU");
        //Set the location of the text field and the hitbox.
        CPU.setBounds(70,CPUY,230,25);
        panel.add(CPU);
        CPU.setVisible(true);

        //-----------------Memory-----------------
        int MemY = 70;

        JLabel MemL = new JLabel("Memory");
        MemL.setBounds(15,MemY,50,25);
        panel.add(MemL);
        MemL.setVisible(true);

        Mem = new JTextField("Size");
        Mem.setToolTipText("Size of installed memory");
        Mem.setBounds(70,MemY,70,25);
        panel.add(Mem);
        Mem.setVisible(true);

        //-------------------GPU-----------------
        int GPUY = 100;
        final JLabel GPUL = new JLabel("GPU");
        GPUL.setBounds(15,GPUY,50,25);
        panel.add(GPUL);
        GPUL.setVisible(true);

        GPU = new JTextField("GPU");
        GPU.setToolTipText("GPU");
        GPU.setBounds(70,GPUY,190,25);
        panel.add(GPU);
        GPU.setVisible(true);

        final JLabel VRAML = new JLabel("VRAM");
        VRAML.setBounds(270,GPUY,50,25);
        panel.add(VRAML);
        VRAML.setVisible(true);

        VRAM = new JTextField("Size");
        VRAM.setBounds(320,GPUY,50,25);
        panel.add(VRAM);
        VRAM.setVisible(true);

        //---------------OS------------------------
        int OSY = 190;
        JLabel OSL = new JLabel("OS");
        OSL.setBounds(15,OSY,50,25);
        panel.add(OSL);
        OSL.setVisible(true);

        OS = new JTextField("Operating System");
        OS.setToolTipText("Operating System");
        OS.setBounds(70,OSY,230,25);
        panel.add(OS);
        OS.setVisible(true);

        //--------------------Drive 1--------------
        int D1Y = 130;
        JLabel Drive1L = new JLabel("Drive 1");
        Drive1L.setBounds(15,D1Y,50,25);
        panel.add(Drive1L);
        Drive1L.setVisible(true);

        DriveSize1 = new JTextField("Size");
        DriveSize1.setToolTipText("Drive 1 Size");
        DriveSize1.setBounds(70,D1Y,110,25);
        panel.add(DriveSize1);
        DriveSize1.setVisible(true);

        JLabel DriveType1L = new JLabel("Type:");
        DriveType1L.setBounds(190,D1Y,70,25);
        panel.add(DriveType1L);
        DriveType1L.setVisible(true);

        DriveType1 = new JComboBox<String>(DriveTypes);
        DriveType1.setBounds(239,D1Y,60,25);
        panel.add(DriveType1);
        DriveType1.setVisible(true);

        //--------------------Drive 2--------------
        int D2Y = 160;
        JLabel Drive2L = new JLabel("Drive 2");
        Drive2L.setBounds(15,D2Y,50,25);
        panel.add(Drive2L);
        Drive2L.setVisible(true);

        DriveSize2 = new JTextField("Size");
        DriveSize2.setToolTipText("Drive 2 Size");
        DriveSize2.setBounds(70,D2Y,110,25);
        panel.add(DriveSize2);
        DriveSize2.setVisible(true);

        JLabel DriveType2L = new JLabel("Type:");
        DriveType2L.setBounds(190,D2Y,70,25);
        panel.add(DriveType2L);
        DriveType2L.setVisible(true);

        DriveType2 = new JComboBox<String>(DriveTypes);
        DriveType2.setBounds(239,D2Y,60,25);
        panel.add(DriveType2);
        DriveType2.setVisible(true);

        updating = new JLabel("Retrieving System Info. Please wait.");
        updating.setBounds(300,500,400,25);
        panel.add(updating);
        updating.setVisible(Updating);

        //panel.paintComponet(g.create());

        if(Main.isVerbose()){System.out.println("Componets added to frame");}
        frame.setVisible(true);
        if(Main.isVerbose()){System.out.println("Frame set to visible");}


    }

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
