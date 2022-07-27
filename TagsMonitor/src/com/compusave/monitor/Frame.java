package com.compusave.monitor;

import javax.swing.*;
import java.awt.*;

public class Frame {

    private static JFrame frame;
    public static Dimension size = new Dimension(500,600);


    public Frame(){
        Init();
        PostInit();
    }

    private static void Init(){
        frame = new JFrame();
        frame.setSize(size);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    private static void PostInit(){
        frame.setVisible(true);
    }

    private static JMenuBar menubar;
    private static JMenu file, view, settings;

    private static void Componenets(){
        menubar = new JMenuBar();
    }

}
