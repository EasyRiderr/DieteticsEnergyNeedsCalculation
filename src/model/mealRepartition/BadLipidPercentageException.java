/*
 * BadLipidPercentageException.java
 * 
 * Exception thrown if the percentage of lipid is incorrect.
 * 25/01/2014 
 */


package model.mealRepartition;


/**
 * Exception thrown if the percentage of lipid is incorrect.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class BadLipidPercentageException extends Exception {

	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;

	public BadLipidPercentageException(String msg) {
		super(msg);
	}
}
