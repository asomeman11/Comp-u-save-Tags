package com.compusave.tags;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class Panel extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(550,10,550,465);
        g.drawLine(10,465,770,465);
        g.drawLine(550,250,770,250);
    }
}
