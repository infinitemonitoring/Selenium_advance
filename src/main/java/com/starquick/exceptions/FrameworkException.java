package com.starquick.exceptions;

@SuppressWarnings("serial")
public class FrameworkException extends FileNotpathFoundException{

	public FrameworkException(String message) {
		super(message);
	
	}
	public FrameworkException(String message,Throwable cause) {
		super(message, cause);
	
	}

}
