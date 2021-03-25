package com.compusave.tags;

import com.compusave.tags.Debug.Console.Cmd;
import com.sun.corba.se.impl.orbutil.concurrent.DebugMutex;

import static com.compusave.tags.SysInfo.*;

@SuppressWarnings("unused")
public class Main {

    private static boolean Debug = false;
    public static boolean isDebug(){return Debug;}
    public static void setDebug(boolean debug){Debug = debug;}
    private static Boolean Verbose = false;
    public static boolean isVerbose() {return Verbose;}
    public static void setVerbose(boolean verbose){Verbose = verbose;}
    private static boolean Manual = false;
    public static boolean isManual(){return Manual;}
    public static void setManual(boolean manual){Manual = manual;}

    private static Thread CMD;

    public static void main(String[] args){
        for (String arg : args) {
            switch (arg.toUpperCase()) {
                case "DEBUG":
                    Debug = true;
                    System.out.println("Debug mode enabled!");
                    break;
                case "VERBOSE":
                    Verbose = true;
                    System.out.println("Verbose mode enabled!");
                    break;
                case "MANUAL":
                    Manual = true;
                    System.out.println("Manual input mode selected! Will not run sysinfo update.");
                    break;
                default:
                    System.err.println("Invalid Command \"" + arg + "\"");
                    break;
            }
        }
       new Frame();
       System.out.println("Retrieving System Info");
       GetSysInfo();
       Frame.updateFrame(getOS(), getCPU(), Math.round(getMemory() / 1073741824), getGPU());
       CMD = new Thread();
       CMD.start();
    }

    public static void Stop(){
        System.out.println("Program Successfully closed.");
        System.exit(0);
    }
}
