package com.compusave.tags.Debug.Console;

import com.compusave.tags.Main;

import java.util.Scanner;

public class Cmd implements Runnable{

    public static void cmdIN(){
        Scanner in = new Scanner(System.in);

        String[] uin = in.nextLine().toString().toUpperCase().split("");
    }

    private static void validate(String[] Input){
        for (int x =0; x < Input.length; x++){
            switch (Input[x]){
                case "DEBUG":
                    if (!Main.isDebug()){
                        Main.setDebug(true);
                        System.out.println("Debug mode on");
                    }else {
                        Main.setDebug(false);
                        System.out.println("Debug mode off");
                    }
                    break;
                case "VERBOSE":
                    if (!Main.isVerbose()){
                        Main.setVerbose(true);
                        System.out.println("Verbose mode on");
                    }else {
                        Main.setVerbose(false);
                        System.out.println("Verbose mode off");
                    }
                    break;
                default:
                    System.out.println(Input[x] + "is an invalid command. I'm Dislexic, whast yoru ecxuse?");
                    break;
            }
        }
    }

    @Override
    public void run() {
        cmdIN();
    }
}
