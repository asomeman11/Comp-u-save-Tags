package com.compusave.tags;


/*+
This class will be used when the user attempts to submit
a tag with an invalid argument or missing field that is
required.

Currently this is a low priority class and is being used
as a placeholder. Will be used in a future update.

 */
@SuppressWarnings("all")
public class Erroralets {

    public enum error{InvalidArgument, MissingTextField, }

    Erroralets(error err, String msg){
        System.err.println("WARNING! An error has occurred." + err + "/s/s" + msg);
    }

}
