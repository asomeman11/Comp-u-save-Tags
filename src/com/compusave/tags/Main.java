package com.compusave.tags;

import static com.compusave.tags.SysInfo.*;

public class Main {

    private static Boolean Debug = false;

    public static void main(String[] args){
        for (int x = 0; x < args.length;){

        }


       Frame.FrameInit();
       System.out.println("Retrieving System Info");
       GetSysInfo();
       Frame.updateFrame(getOS(), getCPU(), 0, getGPU());

    }

    public static void Stop(){
        System.out.println("Program Successfully closed.");
        System.exit(0);

    }

}
