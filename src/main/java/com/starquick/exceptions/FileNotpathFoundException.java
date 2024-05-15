package com.starquick.exceptions;

@SuppressWarnings("serial")
public class FileNotpathFoundException extends RuntimeException{

	  public FileNotpathFoundException(String message) {
	        super(message);
	    }

	  public FileNotpathFoundException(String message, Throwable cause) {
	        super(message,cause);
	    }
}
