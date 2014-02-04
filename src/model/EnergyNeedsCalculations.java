/*
 * EnergyNeedsCalculations.java
 * 
 * This class will permit to calculate energy needs of a patient.
 * 24/01/2014 
 */


package model;

import model.exception.BadCarbohydratePercentageException;
import model.exception.BadLipidPercentageException;
import model.exception.BadProteinPercentageException;
import model.exception.PercentageMisallocationException;
import model.metabolism.Gender;


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
	 * @return The Basal Metabolic Rate of the patient.
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
	public static double getTotalNRJIntakeNeeds(double energyNeeds, Meal meal) {
		return energyNeeds * meal.getPercentageOfNRJNeeds();
	}


	/**
	 * Return the weight <i>(in grams)</i> of animal proteins that can be consumed by the patient.
	 * @param totalNRJIntakeNeeds, The total energy intakes needs of the patient.
	 * @param proteinsPercentage, The wished percentage of proteins (animal and vegetable) of the total energy intakes.
	 * @return The weight <i>(in grams)</i> of animal proteins that can be consumed by the patient.
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 */
	public static double getAnimalProteinsInGrams(double totalNRJIntakeNeeds, double proteinsPercentage) throws BadProteinPercentageException {
		// Verify that the percentage of proteins is correct
		if(proteinsPercentage < 0.12 || proteinsPercentage > 0.15) {
			throw new BadProteinPercentageException("The percentage of protein must be between 12% and 15%.");
		}
		return (totalNRJIntakeNeeds * proteinsPercentage / 2.0) / 17.0;
	}


	/**
	 * Return the weight <i>(in grams)</i> of vegetable proteins that can be consumed by the patient.
	 * @param totalNRJIntakeNeeds, The total energy intakes needs of the patient.
	 * @param proteinsPercentage, The wished percentage of proteins (animal and vegetable) of the total energy intakes.
	 * @return The weight <i>(in grams)</i> of animal proteins that can be consumed by the patient.
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 */
	public static double getVegetableProteinsInGrams(double totalNRJIntakeNeeds, double proteinsPercentage) throws BadProteinPercentageException {
		// Verify that the percentage of proteins is correct
		if(proteinsPercentage < 0.12 || proteinsPercentage > 0.15) {
			throw new BadProteinPercentageException("The percentage of protein must be between 12% and 15%.");
		}
		return (totalNRJIntakeNeeds * proteinsPercentage / 2.0) / 17.0;
	}


	/**
	 * Return the weight <i>(in grams)</i> of animal lipid that can be consumed by the patient.
	 * @param totalNRJIntakesNeeds, The total energy intakes needs of the patient.
	 * @param lipidPercentage, The wished percentage of lipids (animal and vegetable) of the total energy intakes.
	 * @return The weight <i>(in grams)</i> of animal lipid that can be consumed by the patient.
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 */
	public static double getAnimalLipidInGrams(double totalNRJIntakesNeeds, double lipidPercentage) throws BadLipidPercentageException {
		// Verify that the percentage of lipid is correct
		if(lipidPercentage < 0.35 || lipidPercentage > 0.4) {
			throw new BadLipidPercentageException("The percentage of lipid must be between 35% and 40%.");
		}
		return (totalNRJIntakesNeeds * lipidPercentage / 2.0) / 38.0;
	}


	/**
	 * Return the weight <i>(in grams)</i> of vegetable lipid that can be consumed by the patient.
	 * @param totalNRJIntakesNeeds, The total energy intakes needs of the patient.
	 * @param lipidPercentage, The wished percentage of lipids (animal and vegetable) of the total energy intakes.
	 * @return The weight <i>(in grams)</i> of vegetable lipid that can be consumed by the patient.
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 */
	public static double getVegetableLipidInGrams(double totalNRJIntakesNeeds, double lipidPercentage) throws BadLipidPercentageException {
		// Verify that the percentage of lipid is correct
		if(lipidPercentage < 0.35 || lipidPercentage > 0.4) {
			throw new BadLipidPercentageException("The percentage of lipid must be between 35% and 40%.");
		}
		return (totalNRJIntakesNeeds * lipidPercentage / 2.0) / 38.0;
	}


	/**
	 * Return the weight <i>(in grams)</i> of complex carbohydrate that can be consumed by the patient.
	 * @param totalNRJIntakesNeeds, The total energy intakes needs of the patient.
	 * @param carbohydratePercentage, The wished percentage of carbohydrate (complex and simple) of the total energy intakes.
	 * @return The weight <i>(in grams)</i> of complex carbohydrate that can be consumed by the patient.
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 */
	public static double getComplexCarbohydrate(double totalNRJIntakesNeeds, double carbohydratePercentage) throws BadCarbohydratePercentageException {
		// Verify that the percentage of carbohydrate is correct
		if(carbohydratePercentage < 0.50 || carbohydratePercentage > 0.55) {
			throw new BadCarbohydratePercentageException("The percentage of carbohydrate must be between 50% and 55%.");
		}
		return totalNRJIntakesNeeds * carbohydratePercentage * 0.55 / 17.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of simple carbohydrate that can be consumed by the patient.
	 * @param totalNRJIntakesNeeds, The total energy intakes needs of the patient.
	 * @param carbohydratePercentage, The wished percentage of carbohydrate (complex and simple) of the total energy intakes.
	 * @return The weight <i>(in grams)</i> of simple carbohydrate that can be consumed by the patient.
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 */
	public static double getSimpleCarbohydrate(double totalNRJIntakesNeeds, double carbohydratePercentage) throws BadCarbohydratePercentageException {
		// Verify that the percentage of carbohydrate is correct
		if(carbohydratePercentage < 0.50 || carbohydratePercentage > 0.55) {
			throw new BadCarbohydratePercentageException("The percentage of carbohydrate must be between 50% and 55%.");
		}
		return totalNRJIntakesNeeds * carbohydratePercentage * 0.45 / 17.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of sweetened products that can be consumed by the patient.
	 * @param totalNRJIntakesNeeds, The total energy intakes needs of the patient.
	 * @return The weight <i>(in grams)</i> of sweetened products that can be consumed by the patient.
	 */
	public static double getSweetenedProductsinGrams(double totalNRJIntakesNeeds) {
		return totalNRJIntakesNeeds * 0.1 / 17.0;
	}
	
	
	/**
	 * Asserts that the sum of proteins, lipids and carbohydrate percentages are equal to 100%.
	 * @param proteinPercentage, The percentage of protein.
	 * @param lipidPercentage, The percentage of lipid.
	 * @param carbohydratePercentage, The percentage of carbohydrate.
	 * @throws PercentageMisallocationException, The sum of proteins, lipids and carbohydrate percentages must be equal to 100%.
	 */
	public static void isPercentgaeCorrect(double proteinPercentage, double lipidPercentage, double carbohydratePercentage) throws PercentageMisallocationException {
		if(proteinPercentage + lipidPercentage + carbohydratePercentage != 1.) {
			throw new PercentageMisallocationException("The total of proteins, lipids and carbohydrate percentage must be eaqual to 100%");
		}
	}
	
}
