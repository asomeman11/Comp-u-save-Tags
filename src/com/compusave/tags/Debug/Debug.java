package com.compusave.tags.Debug;

import com.compusave.tags.Exceptions.InvalidRightsException;

public class Debug {

    enum Adminlvl {Standard, advanced, admin}

    Debug(Adminlvl lvl) throws Exception {
        switch (lvl){
            case Standard:
                Console();
                break;
            case advanced:
                ConsoleCHK();
                break;
            case admin:
                new Admin();
                break;
            default:
                throw new InvalidRightsException("You do not have permissions to enter debug mode.");
        }

    }

    public static void Console(){

    }

    public static void ConsoleCHK(){

    }

}
