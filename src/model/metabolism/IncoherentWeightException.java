/*
 * IncoherentWeightException.java
 * 
 * Exception thrown if the weight of the patient is incoherent.
 * 03/02/2014 
 */


package model.metabolism;


/**
 * Exception thrown if the weight of the patient is incoherent.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class IncoherentWeightException extends Exception {

	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Constructor of incoherent weight exception.
	 * @param msg, The error message.
	 */
	public IncoherentWeightException(String msg) {
		super(msg);
	}

}
