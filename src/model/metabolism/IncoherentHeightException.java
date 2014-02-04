/*
 * IncoherentHeightException.java
 * 
 * Exception thrown if the height of the patient is incoherent.
 * 03/02/2014 
 */


package model.metabolism;


/**
 * Exception thrown if the height of the patient is incoherent.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class IncoherentHeightException extends Exception {

	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Constructor of incoherent height exception.
	 * @param msg, The message describing the error.
	 */
	public IncoherentHeightException(String msg) {
		super(msg);
	}

}
