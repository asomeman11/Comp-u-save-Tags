package com.compusave.tags;

public class Erroralets {

    public static enum error{InvalidArgument, MissingTextField, };

    /*

     */
    Erroralets(error err, String msg){
        System.err.println("WARNING! An error has occurred." + err + "/s/s" + msg);
    }

}
