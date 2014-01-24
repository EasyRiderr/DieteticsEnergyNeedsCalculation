/*
 * Meal.java
 * 
 * Describes the different meals of the day.
 * 24/01/2014 
 */


package model;


/**
 * Describes the different meals of the day.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public enum Meal {
	// Constructors to call
	Breakfast(0.25),
	Lunch(0.35),
	LunchWithoutSnack(0.4),
	Dinner(0.3),
	DinnerWithoutSnack(0.35),
	Snack(0.1);
	
	
	/** The percentage of total energy needs required for the Meal. */
	private double percentage_;
	
	
	/**
	 * Constructor of Meal.
	 * @param percentage, The percentage of total energy needs required for the Meal.
	 */
	Meal(double percentage) {
		percentage_ = percentage;
	}
	
	
	/**
	 * Return the percentage of energy needs required for the Meal.
	 * @return The percentage of energy needs required for the Meal.
	 */
	public double getPercentageOfNRJNeeds() {
		return percentage_;
	}
}
