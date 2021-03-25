package com.compusave.tags.Exceptions;
/*
This exception is used for properly handling CPU detection errors
This is also used to help with debugging.

@see Throwable
@author Gerry
 */
public class InvalidCPUException extends Throwable {

    public InvalidCPUException(String message){
        super(message);
    }

}
