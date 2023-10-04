package com.militaryaircraft.militaryaircraftapi.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
//
//    public ResourceNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public static ResourceNotFoundException fromChangeSetPersisterNotFoundException(String message) {
//        return new ResourceNotFoundException(message);
//    }
}

