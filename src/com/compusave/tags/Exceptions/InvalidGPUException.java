package com.compusave.tags.Exceptions;

/*
This exception is used for properly handling GPU detection errors
This is also used to help with debugging.

@see Throwable
@author Gerry
 */
public class InvalidGPUException extends Exception{

    public InvalidGPUException(String message){
        super(message);
    }

}
