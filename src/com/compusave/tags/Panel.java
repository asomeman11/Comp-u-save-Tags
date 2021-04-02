package com.compusave.tags;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class Panel extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(300,10,300,600);
    }
}
