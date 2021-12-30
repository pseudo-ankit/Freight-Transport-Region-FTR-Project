package com.FTR.User.exception;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String m) {
		super(m);
	}
}
