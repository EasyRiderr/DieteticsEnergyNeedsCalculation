/*
 * EnergyNeedsCalculations.java
 * 
 * This class will permit to calculate energy needs of a patient.
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
	 * @param gender, The gender of the patient.
	 * @return
	 */
	public static double getBMR(double weight, int age, double height, Gender gender) {
		return gender.getGenderCoeff() * Math.pow(weight, 0.48) * Math.pow(height, 0.5) * Math.pow(age, -0.13);
	}
	
	
	/**
	 * Return the Energy needs of the patient.
	 * @param bmr, The Base Metabolic Rate of the patient.
	 * @param lpa, The level of physical activity of the patient.
	 * @return The energy needs of the patient in kJ.
	 */
	public static double getEnergyNeeds(double bmr, double lpa) {
		return bmr * lpa * 1000;
	}
	
	
	/**
	 * Return the total energy intakes required for the meal.
	 * @param energyNeeds, Energy needs of the patient.
	 * @param meal, The meal to calculate energy intakes.
	 * @return The total energy intakes required for the meal in kJ.
	 */
	public static double getTotalNRJIntake(double energyNeeds, Meal meal) {
		return energyNeeds * meal.getPercentageOfNRJNeeds();
	}
}