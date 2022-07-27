package com.compusave.tags;

public class Submit {

    public Submit(Object[] Sysinfo) {
        System.out.println("Submit button test!");

        if (Frame.getUpdatingStatus()) {
            System.out.println(Frame.getUpdatingStatus());
            System.err.println("Please wait till all information is loaded.");
            Frame.setUpdatingL("Please wait till all information is loaded.");
        } else {
            System.out.println(Frame.getUpdatingStatus());
            for (int x = 0; Sysinfo.length > x; x++) {
                System.out.println(Sysinfo[x]);
            }

            new TagOut(Sysinfo);

        }
    }
}
