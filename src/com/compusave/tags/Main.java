package com.compusave.tags;

import java.util.Locale;

import static com.compusave.tags.SysInfo.*;

public class Main {

    private static Boolean Debug = false;
    public static boolean isDebug() {return Debug;}
    private static Boolean Verbose = false;

    public static void main(String[] args){
        for (int x = 0; x < args.length; x++){
            switch(args[x].toUpperCase(Locale.ROOT)){
                case "DEBUG":
                    Debug = true;
                    System.out.println("Debug mode enabled!");
                    break;
                case "VERBOSE":
                    Verbose = true;
                    System.out.println("Verbose mode enabled!");
                    break;
                default:
                    System.err.println("Invalid Command \"" + args[x] + "\"");

            }


        }


       Frame fr = new Frame();
       System.out.println("Retrieving System Info");
       GetSysInfo();
       Frame.updateFrame(getOS(), getCPU(), Math.round(getMemory() / 1073741824), getGPU());

    }

    public static void Stop(){
        System.out.println("Program Successfully closed.");
        System.exit(0);

    }

}
