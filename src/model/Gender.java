/*
 * Gender.java
 * 
 * Describes the human gender (male or female).
 * 
 * 24/01/2014 
 */


package model;


/**
 * Describes the human gender.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public enum Gender {
	// Constructors to call
	Male(1.083), 
	Female(0.963);

	/** Define the gender coefficient member. */
	private final double genderCoeff_;
	
	
	/** 
	 * Constructor of male gender
	 * @param genderCoeff, The gender coefficient.
	 */
	Gender(double genderCoeff) {
		genderCoeff_ = genderCoeff;	
	}
	
	
	/**
	 * Return the gender coefficient.
	 * @return The gender coefficient.
	 */
	public double getGenderCoeff() {
		return this.genderCoeff_;
	}
};

