/*
 * MealRepartition.java
 * 
 * Represent the meal repartition of a patient.
 * 16/02/2014 
 */


package model.mealRepartition;

import java.util.Observable;


/**
 * MealRepartition represent the meal repartition of a patient.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Meal
 */
public class MealRepartition extends Observable {

	/** The carbohydrate percentage wished for the meal. */
	private double carbohydratePercentage;

	/** The lipid percentage wished for the meal. */
	private double lipidPercentage;

	/** The protein percentage wished for the meal. */
	private double proteinPercentage;

	/** Permit to know if the patient take a snack. */
	private boolean takeASnack;


	/**
	 * The default constructor of MealRepartition.
	 */
	public MealRepartition() {
		try {
			setCarbohydratePercentage(.5);
			setLipidPercentage(.35);
			setProteinPercentage(.15);
		} catch(Exception e) {}
		setTakeASnack(true);
	}


	/**
	 * Constructor of MealRepartition.
	 * @param carbohydratePercentage, The percentage of carbohydrate allowed for the patient by meal.
	 * @param lipidPercentage, The percentage of lipid allowed for the patient by meal.
	 * @param proteinPercentage, The percentage of protein allowed for the patient by meal.
	 * @param takeASnack, True if the patient take a snack, false otherwise.
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 * @throws PercentageMisallocationException, The sum of proteins, lipids and carbohydrate percentages must be equal to 100%.
	 */
	public MealRepartition(double carbohydratePercentage, double lipidPercentage, double proteinPercentage, boolean takeASnack) throws BadCarbohydratePercentageException, BadLipidPercentageException, BadProteinPercentageException, PercentageMisallocationException {
		setCarbohydratePercentage(carbohydratePercentage);
		setLipidPercentage(lipidPercentage);
		setProteinPercentage(proteinPercentage);
		checkRepartition();
		setTakeASnack(takeASnack);
	}


	/**
	 * Verify that the repartition of percentage is correct.
	 * @throws PercentageMisallocationException, The sum of proteins, lipids and carbohydrate percentages must be equal to 100%.
	 */
	public void checkRepartition() throws PercentageMisallocationException {
		if(carbohydratePercentage + lipidPercentage + proteinPercentage != 1) {
			throw new PercentageMisallocationException("The total of proteins, lipids and carbohydrate percentage must be equal to 100%.");
		}
	}


	/**
	 * @return the carbohydratePercentage
	 */
	public double getCarbohydratePercentage() {
		return carbohydratePercentage;
	}


	/**
	 * @param carbohydratePercentage the carbohydratePercentage to set
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 */
	public void setCarbohydratePercentage(double carbohydratePercentage) throws BadCarbohydratePercentageException {
		if(carbohydratePercentage <.5 || carbohydratePercentage > .55) {
			throw new BadCarbohydratePercentageException("The percentage of carbohydrate must be between 50% and 55%.");
		}
		this.carbohydratePercentage = carbohydratePercentage;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}


	/**
	 * @return the lipidPercentage
	 */
	public double getLipidPercentage() {
		return lipidPercentage;
	}


	/**
	 * @param lipidPercentage the lipidPercentage to set
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 */
	public void setLipidPercentage(double lipidPercentage) throws BadLipidPercentageException  {
		if(lipidPercentage < 0.35 || lipidPercentage > 0.4) {
			throw new BadLipidPercentageException("The percentage of lipid must be between 35% and 40%.");
		}
		this.lipidPercentage = lipidPercentage;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}


	/**
	 * @return the proteinPercentage
	 */
	public double getProteinPercentage() {
		return proteinPercentage;
	}


	/**
	 * @param proteinPercentage the proteinPercentage to set
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 */
	public void setProteinPercentage(double proteinPercentage) throws BadProteinPercentageException {
		if(proteinPercentage < 0.12 || proteinPercentage > 0.15) {
			throw new BadProteinPercentageException("The percentage of protein must be between 12% and 15%.");
		}
		this.proteinPercentage = proteinPercentage;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}


	/**
	 * @return the takeASnack
	 */
	public boolean isTakeASnack() {
		return takeASnack;
	}


	/**
	 * @param takeASnack the takeASnack to set
	 */
	public void setTakeASnack(boolean takeASnack) {
		this.takeASnack = takeASnack;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}
}
