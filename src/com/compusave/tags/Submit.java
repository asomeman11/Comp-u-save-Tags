package com.compusave.tags;

public class Submit {

    public Submit(Object[] Sysinfo){
        System.out.println("Submit button test!");

        for(int x = 0; Sysinfo.length > x; x++){
            System.out.println(Sysinfo[x]);
        }

        //new TagOut(Sysinfo);

    }
}
