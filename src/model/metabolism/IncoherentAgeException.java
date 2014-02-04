/*
 * IncoherentAgeException.java
 * 
 * Exception thrown if the age of the patient is incoherent.
 * 03/02/2014 
 */


package model.metabolism;


/**
 * Exception thrown if the age of the patient is incoherent.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class IncoherentAgeException extends Exception {

	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Constructor of incoherent age exception.
	 * @param msg, The error message.
	 */
	public IncoherentAgeException(String msg) {
		super(msg);
	}

}
