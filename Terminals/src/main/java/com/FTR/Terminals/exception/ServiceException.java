package com.FTR.Terminals.exception;

public class ServiceException extends Exception {
    
    private static final long serialVersionUID = 1L;


    public ServiceException() {
        super();
    }

    public ServiceException(String errors) {
        super(errors);
    }
    
}
