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

        try {
            tag = new File("C:/Users/Public/Documents/Taginfo.txt");
            System.out.println(tag.getPath());
            if (tag.createNewFile()) {
                System.out.println("Tag made");
            } else {
                System.err.println("Previous Tag Present! Eliminating Threat!!");
                tag.delete();
                System.out.println("Enemy overthrown, new tag Generated");
            }
            this.SysInfo = SysInfo;
            TagGenerate();
            Frame.setUpdatingL("Tag Generated. You may now close the client.");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void TagGenerate(){
        try {
            FW = new FileWriter(tag);
            for (int x =0; x < SysInfo.length; x++){
                FW.write(SysInfo[x].toString() + "\n");
            }
            FW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
