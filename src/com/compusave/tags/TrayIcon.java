package com.compusave.tags;

import java.awt.*;

public class TrayIcon {

    TrayIcon(){
        if (!SystemTray.isSupported()){
            System.err.println("System Tray Not Supported.");
            return;
        }

    }
}
