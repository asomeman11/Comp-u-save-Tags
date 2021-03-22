package com.compusave.tags;

import javax.swing.*;
import java.util.Objects;

@SuppressWarnings("all")
public class DeviceSelect {

    private static JFrame Devsel;
    private static ImageIcon Icon;

    DeviceSelect(){
        Frameinit();
    }

    private static void Frameinit(){
        Devsel = new JFrame("Device Selection");
        Icon = new ImageIcon(Objects.requireNonNull(DeviceSelect.class.getClassLoader().getResource("TagsIcon32x32.png")));
        Devsel.setIconImage(Icon.getImage());
    }

    private static void FrameBuild(){
        JButton Windows = new JButton("Windows");
        JButton Mac = new JButton("Mac");
        JButton Linux = new JButton("Linux");

    }

}
