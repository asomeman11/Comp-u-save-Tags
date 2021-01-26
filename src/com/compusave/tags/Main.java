package com.compusave.tags;

import static com.compusave.tags.SysInfo.*;

public class Main {

    public static void main(String[] args){
       Frame.FrameInit();
       System.out.println("test");
       System.out.println("Retrieving System Info");
       GetSysInfo();
       Frame.updateFrame(getOS(), getCPU(), 0, getGPU());

    }

    public static void Stop(){
        System.out.println("Program Successfully closed.");
        System.exit(0);

    }

}
