/*
 * BadProteinPercentageException.java
 * 
 * Exception thrown if the percentage of protein is incorrect.
 * 25/01/2014 
 */


package model.exception;


/**
 * Exception thrown if the percentage of protein is incorrect.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class BadProteinPercentageException extends Exception {

	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;

	public BadProteinPercentageException(String msg) {
		super(msg);
	}
}
