package com.compusave.tags;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Disk;
import com.profesorfalken.jsensors.model.components.Gpu;
import org.jutils.jhardware.model.DisplayInfo;

import java.util.List;


public class SysInfo {

    /*
    This import is from the JSensor Lib
     */
    private static final Components components = JSensors.get.components();
    public static Components GetComponents() {return components;}

    // Defining the system variables.
    private static final String OS = System.getProperty("os.name");
    public static String getOS() {return OS;}
    private static String CPU;
    public static String getCPU() {return CPU;}
    private static String GPU;
    public static String getGPU(){return GPU;}




    public static void GetSysInfo(){

        System.out.println(getOS());
        /*
        Getting CPU information and setting it to a global variable.
        */
        List<Cpu> cpus = components.cpus;
        if (cpus != null) {
            for (final Cpu cpu : cpus) {
                CPU = cpu.name;
                System.out.println(cpu.name);
            }
        }

        /*
        Getting the GPU information and setting it to a global variable.
        */
        //System.out.println();
        List<Gpu> gpus = components.gpus;
        System.out.println(gpus);
        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                GPU = gpu.name;
                System.out.println(gpu.name);
            }
        }else{
            System.err.println("Error reading graphics card data!");
        }


    }

}
