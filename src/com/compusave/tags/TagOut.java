package com.compusave.tags;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unused")
public class TagOut {

    private static Object[] SysInfo;
    private static File tag;
    private static FileWriter FW;

    TagOut(Object[] SysInfo){
        tag = new File("%APPDATA%/Tags/Taginfo.txt");
        if(tag.exists()){
            System.err.println("Previous Tag Present! Eliminating Threat!!");
            tag.delete();
            System.out.println("Tag Generated");
        }
        this.SysInfo = SysInfo;
    }


    private static void TagGenerate(){
        try {
            FW = new FileWriter(tag);
            for (int x =0; x < SysInfo.length; x++){
                FW.append((Character) SysInfo[x]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
