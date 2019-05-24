package com.stackroute.muzix.exceptions;

public class TrackDoesntExistException extends Exception {
    private String message;
    TrackDoesntExistException()
    {

    }
    public TrackDoesntExistException(String message)
    {
        super(message);
        this.message=message;
    }
}
