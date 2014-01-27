/*
 * BadCarbohydratePercentageException.java
 * 
 * Exception thrown if the percentage of carbohydrate is incorrect.
 * 25/01/2014 
 */


package model.exception;


/**
 * Exception thrown if the percentage of carbohydrate is incorrect.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class BadCarbohydratePercentageException extends Exception {

	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;
	
	
	public BadCarbohydratePercentageException(String msg) {
		super(msg);
	}

}
