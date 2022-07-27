package com.compusave.monitor;

/*
This is the Main class for the Tags Monitor which will receive all the submitted tags and import them into
either Photoshop if I have to or preferably Publisher
 */

public class Main {

    //defines the current status of the program.
    private static boolean Running = false;
    public static void setRunning(boolean status){
        Running = status;
    }
    public static boolean getRunning(){
        return Running;
    }
    public static void main(String[] args){
        setRunning(true);
        Frame fr = new Frame();


    }


    public static void run(){
        while (getRunning()){

        }
    }

    private static final String[] StopCodes = {"Success 0", "Success w/ warnings 1", "Success w/ Errors 2", "Unhandled Errors 3"};

    public static void stop(){
        System.out.println("Application stopping, stop code" + StopCodes[0]);
        System.exit(0);
    }

    public static void stop(int sc){
        System.out.println("Application stopping, stop code" + StopCodes[sc]);
        System.exit(sc);
    }

}
