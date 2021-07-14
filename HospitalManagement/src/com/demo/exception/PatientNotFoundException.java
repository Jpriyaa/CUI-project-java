package com.demo.exception;

public class PatientNotFoundException extends Exception{
	public PatientNotFoundException()
	{
		
	}
	public PatientNotFoundException(String message)
	{
		super(message);
	}
    public PatientNotFoundException(Throwable cause)
    {
    	super(cause);
    }

}
