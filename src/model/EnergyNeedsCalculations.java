/*
 * EnergyNeedsCalculations.java
 * 
 * This class will permit to calculate energy needs of a patient.
 * 
 * 24/01/2014 
 */


package model;


/**
 * EnergyNeedsCalculations permits to calculate several energy needs of a patient.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class EnergyNeedsCalculations {
	
	
	/**
	 * Return the Basal Metabolic Rate of the patient.
	 * @param weight, The weight of the patient in kg.
	 * @param age, The age of the patient in years.
	 * @param height, The height of the patient in m.
	 * @param gender, The gender of the patient (male or female).
	 * @return
	 */
	public static double getBMR(float weight, int age, int height, Gender gender) {
		return gender.getGenderCoeff() * Math.pow(weight, 0.48) * Math.pow(height, 0.5) * Math.pow(age, -0.13);
	}
}
