package com.hometask.precords;

public class InvalidArgumentException extends Exception{

    public InvalidArgumentException() {
        super("The input argument is invalid.");
    }
}
