package com.compusave.tags;

import com.compusave.tags.Exceptions.InvalidGPUException;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;

import java.util.List;

/*
This class is responsible for retrieving all the system info
and assigning it to variables that can be read globally

@author Gerry G

 */

public class SysInfo {

    /*
    This import is from the JSensor Lib
     */
    private static final Components components = JSensors.get.components();
    public static Components getComponents() {return components;}

    // Defining the system variables.
    private static final String OS = System.getProperty("os.name");
    public static String getOS() {return OS;}
    private static String CPU;
    public static String getCPU() {return CPU;}
    private static final float Memory = Runtime.getRuntime().maxMemory();
    public static float getMemory(){return Memory;}
    private static String GPU;
    public static String getGPU(){return GPU;}




    public static void GetSysInfo(){
        int mb = 1024 * 1024;

        System.out.println(getMemory() / mb);
        System.out.println(getOS());
        /*
        Getting CPU information and setting it to a global variable.
        @see com.compusave.tags.Exceptions.InvalidCPUException
        @see SysInfo.getCPU();
        */
        List<Cpu> cpus = getComponents().cpus;
        try {
            if (cpus != null) {
                for (final Cpu cpu : cpus) {
                    CPU = cpu.name;
                    System.out.println(getCPU());
                }
            }else{
                throw new InvalidGPUException("It appears somehow you managed to break my program with you strange CPU. Shame on you.");
            }
        }catch (InvalidGPUException e) {
            e.printStackTrace();
        }

        /*
        Getting the GPU information and setting it to a global variable.
        @see com.compusave.tags.Exceptions.InvalidGPUException
        @see SysInfo.getGPU();
        */
        List<Gpu> gpus = getComponents().gpus;
        System.out.println(gpus);
        try {
            if (gpus != null) {
                for (final Gpu gpu : gpus) {
                    GPU = gpu.name;
                    if (!getGPU().equals("[]")) {
                        System.out.println(getGPU());
                    } else {
                        throw new InvalidGPUException("It appears the system cannot properly obtain the GPU info. Does the System have integrated graphics?");
                    }
                }
            }
        } catch (InvalidGPUException e) {
            System.out.println("Unable to determine GPU. Please manually add it to the tag.");
            e.printStackTrace();
        }


    }

}
