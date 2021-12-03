package com.compusave.tags;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class Panel extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(450,10,450,465);
        g.drawLine(10,465,700,465);
        g.drawLine(450,250,700,250);
    }
}
