package com.compusave.tags;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public void paintComponet(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(300,10,300,600);

    }
}
