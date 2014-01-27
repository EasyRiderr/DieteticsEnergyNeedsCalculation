/*
 * PercentageMisallocationException.java
 * 
 * Exception thrown if the sum of percentages of carbohydrate, proteins and lipid is different of 100%.
 * 25/01/2014 
 */


package model.exception;


/**
 * Exception thrown if the sum of percentages of carbohydrate, proteins and lipid is different of 100%.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class PercentageMisallocationException extends Exception {

	/** the ID of serialization. */
	private static final long serialVersionUID = 1L;
	
	
	public PercentageMisallocationException(String msg) {
		super(msg);
	}

}
