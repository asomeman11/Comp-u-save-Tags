package com.compusave.tags;

import com.compusave.tags.Exceptions.InvalidCPUException;
import com.compusave.tags.Exceptions.InvalidGPUException;
import com.compusave.tags.Exceptions.InvalidOSException;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;

import java.lang.management.ManagementFactory;
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
    private static final long Memory = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
    public static float getMemory(){return Memory;}
    private static String GPU;
    public static String getGPU(){return GPU;}



    public static void GetSysInfo(){

        //17143336960
        //1073741824
        try {
            switch (getOS().toUpperCase()) {
                case "WINDOWS 10":
                    WinInfo();
                    break;
                case "MACOS":
                    MacInfo();
                    break;
                case "Linux":
                    LinuxInfo();
                    break;
                default:
                    throw new InvalidOSException("ERROR! OS " + getOS() + "is currently not a properly supported OS. Curse you for finding problems with my code." +
                            "You may manually enter the tag info. Please report this to Gerry for a proper scolding.");
            }
        } catch (InvalidOSException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());

        }


    }

    private static void WinInfo(){
        if(Main.isVerbose()){System.out.println(Math.round(getMemory() / 1073741824));}
        if(Main.isVerbose()){System.out.println(getOS());}
        /*
        Getting CPU information and setting it to a global variable.
        @see com.com.compusave.com.compusave.tags.Exceptions.InvalidCPUException
        @see SysInfo.getCPU();
        */
        List<Cpu> cpus = getComponents().cpus;
        try {
            if (cpus != null) {
                for (final Cpu cpu : cpus) {
                    CPU = cpu.name;
                    if(Main.isVerbose()){System.out.println(getCPU());}
                }
            }else{
                throw new InvalidCPUException("It appears somehow you managed to break my program with you strange CPU. Shame on you.");
            }
        }catch (InvalidCPUException e) {
            e.printStackTrace();
        }

        /*
        Getting the GPU information and setting it to a global variable.
        @see com.com.compusave.com.compusave.tags.Exceptions.InvalidGPUException
        @see SysInfo.getGPU();
        */
        List<Gpu> gpus = getComponents().gpus;
        if(Main.isVerbose()){System.out.println(gpus);}
        try {
            if (gpus != null) {
                for (final Gpu gpu : gpus) {
                    GPU = gpu.name;
                    if (!getGPU().equals("[]")) {
                        if(Main.isVerbose()){System.out.println(getGPU());}
                    } else {
                        throw new InvalidGPUException("It appears the system cannot properly obtain the GPU info. Does the System have integrated graphics?");
                    }
                }
            }
        } catch (InvalidGPUException e) {
            System.out.println("Unable to determine GPU. Please manually add it to the tag.");
            e.printStackTrace();
        }
        Frame.setUpdatingStatus(false);
    }

    private static void MacInfo(){

    }

    private static void LinuxInfo(){

    }
}
