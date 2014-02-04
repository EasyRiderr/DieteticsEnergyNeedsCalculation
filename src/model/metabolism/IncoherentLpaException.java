/*
 * IncoherentLpaException.java
 * 
 * Exception thrown if the level of physical activities of the patient is incoherent.
 * 03/02/2014 
 */


package model.metabolism;


/**
 * Exception thrown if the level of physical activities of the patient is incoherent.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class IncoherentLpaException extends Exception {

	/**The ID of serialization. */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor of incoherent level of activities exception.
	 * @param msg, The message describing the error.
	 */
	public IncoherentLpaException(String msg) {
		super(msg);
	}
}
