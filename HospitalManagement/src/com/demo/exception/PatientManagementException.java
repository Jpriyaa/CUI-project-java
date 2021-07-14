package com.demo.exception;

public class PatientManagementException extends Exception{
	public PatientManagementException()
	{
		
	}
	public PatientManagementException(String message)
	{
		super(message);
	}
    public PatientManagementException(Throwable cause)
    {
    	super(cause);
    }
	

}
