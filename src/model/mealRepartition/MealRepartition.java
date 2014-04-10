/*
 * MealRepartition.java
 * 
 * Represent the meal repartition of a patient.
 * 16/02/2014 
 */


package model.mealRepartition;

import java.util.Observable;
import java.util.Observer;


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
	public static final double CARBOHYDRATE_PERCENTAGE_MIN = .5;
	public static final double CARBOHYDRATE_PERCENTAGE_MAX = .55;

	/** The lipid percentage wished for the meal. */
	private double lipidPercentage;
	public static final double LIPID_PERCENTAGE_MIN = .35;
	public static final double LIPID_PERCENTAGE_MAX = .4;

	/** The protein percentage wished for the meal. */
	private double proteinPercentage;
	public static final double PROTEIN_PERCENTAGE_MIN = .12;
	public static final double PROTEIN_PERCENTAGE_MAX = .15;

	/** Permit to know if the patient take a snack. */
	private boolean takeASnack;
	
	/** Energy needs of the patient. */
	private double energyNeeds;


	/**
	 * The default constructor of MealRepartition.
	 */
	public MealRepartition() {
		try {
			setCarbohydratePercentage(CARBOHYDRATE_PERCENTAGE_MIN);
			setLipidPercentage(LIPID_PERCENTAGE_MIN);
			setProteinPercentage(PROTEIN_PERCENTAGE_MAX);
		} catch(Exception e) {}
		setTakeASnack(true);
		setEnergyNeeds(6000);
	}


	/**
	 * Constructor of MealRepartition.
	 * @param carbohydratePercentage, The percentage of carbohydrate allowed for the patient by meal.
	 * @param lipidPercentage, The percentage of lipid allowed for the patient by meal.
	 * @param proteinPercentage, The percentage of protein allowed for the patient by meal.
	 * @param takeASnack, True if the patient take a snack, false otherwise.
	 * @param energyNeeds, Energy needs of the patient.
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 * @throws PercentageMisallocationException, The sum of proteins, lipids and carbohydrate percentages must be equal to 100%.
	 */
	public MealRepartition(double carbohydratePercentage, double lipidPercentage, double proteinPercentage, boolean takeASnack, double energyNeeds) throws BadCarbohydratePercentageException, BadLipidPercentageException, BadProteinPercentageException, PercentageMisallocationException {
		setCarbohydratePercentage(carbohydratePercentage);
		setLipidPercentage(lipidPercentage);
		setProteinPercentage(proteinPercentage);
		checkRepartition();
		setTakeASnack(takeASnack);
		setEnergyNeeds(energyNeeds);
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
	 * @return the energyNeeds
	 */
	public double getEnergyNeeds() {
		return energyNeeds;
	}


	/**
	 * @param energyNeeds the energyNeeds to set
	 */
	public void setEnergyNeeds(double energyNeeds) {
		this.energyNeeds = energyNeeds;

		// Notify changes
		this.setChanged();
		this.notifyObservers();
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
		if(carbohydratePercentage <CARBOHYDRATE_PERCENTAGE_MIN || carbohydratePercentage > CARBOHYDRATE_PERCENTAGE_MAX) {
			throw new BadCarbohydratePercentageException("The percentage of carbohydrate must be between " + (int)(CARBOHYDRATE_PERCENTAGE_MIN * 100) + "% and " + (int)(CARBOHYDRATE_PERCENTAGE_MAX * 100) + "%.");
		}
		this.carbohydratePercentage = carbohydratePercentage;

		// Notify changes
		this.setChanged();
		this.notifyObservers();
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
		if(lipidPercentage < LIPID_PERCENTAGE_MIN || lipidPercentage > LIPID_PERCENTAGE_MAX) {
			throw new BadLipidPercentageException("The percentage of lipid must be between " + (int)(LIPID_PERCENTAGE_MIN * 100) + "% and " + (int)(LIPID_PERCENTAGE_MAX * 100) + "%.");
		}
		this.lipidPercentage = lipidPercentage;

		// Notify changes
		this.setChanged();
		this.notifyObservers();
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
		if(proteinPercentage < PROTEIN_PERCENTAGE_MIN || proteinPercentage > PROTEIN_PERCENTAGE_MAX) {
			throw new BadProteinPercentageException("The percentage of protein must be between " + (int)(PROTEIN_PERCENTAGE_MIN * 100) + "% and " + (int)(PROTEIN_PERCENTAGE_MAX * 100) + "%.");
		}
		this.proteinPercentage = proteinPercentage;

		// Notify changes
		this.setChanged();
		this.notifyObservers();
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
		this.notifyObservers();
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of animal proteins that can be consumed by the patient.
	 * @param meal, The meal to compute animal proteins.
	 * @return The weight <i>(in grams)</i> of animal proteins that can be consumed by the patient.
	 */
	public double getAnimalProteinsInGrams(Meal meal) {
		return (energyNeeds * meal.getPercentageOfNRJNeeds() * proteinPercentage / 2.0) / 17.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of vegetable proteins that can be consumed by the patient.
	 * @param meal, The meal to compute vegetable proteins.
	 * @return The weight <i>(in grams)</i> of animal proteins that can be consumed by the patient.
	 */
	public double getVegetableProteinsInGrams(Meal meal) {
		return (energyNeeds * meal.getPercentageOfNRJNeeds() * proteinPercentage / 2.0) / 17.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of animal lipid that can be consumed by the patient.
	 * @param meal, The meal to compute animal lipid.
	 * @return The weight <i>(in grams)</i> of animal lipid that can be consumed by the patient.
	 */
	public double getAnimalLipidInGrams(Meal meal) {
		return (energyNeeds * meal.getPercentageOfNRJNeeds() * lipidPercentage / 2.0) / 38.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of vegetable lipid that can be consumed by the patient.
	 * @param meal, The meal to compute vegetable lipid.
	 * @return The weight <i>(in grams)</i> of vegetable lipid that can be consumed by the patient.
	 */
	public double getVegetableLipidInGrams(Meal meal) {
		return (energyNeeds * meal.getPercentageOfNRJNeeds() * lipidPercentage / 2.0) / 38.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of complex carbohydrate that can be consumed by the patient.
	 * @param meal, The meal to compute complex carbohydrate.
	 * @return The weight <i>(in grams)</i> of complex carbohydrate that can be consumed by the patient.
	 */
	public double getComplexCarbohydrate(Meal meal) {
		return energyNeeds * meal.getPercentageOfNRJNeeds() * carbohydratePercentage * 0.55 / 17.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of simple carbohydrate that can be consumed by the patient.
	 * @param meal, The meal to compute simple carbohydrate.
	 * @return The weight <i>(in grams)</i> of simple carbohydrate that can be consumed by the patient.
	 */
	public double getSimpleCarbohydrate(Meal meal) {
		return energyNeeds * meal.getPercentageOfNRJNeeds() * carbohydratePercentage * 0.45 / 17.0;
	}
	
	
	/**
	 * Return the weight <i>(in grams)</i> of sweetened products that can be consumed by the patient.
	 * @return The weight <i>(in grams)</i> of sweetened products that can be consumed by the patient.
	 */
	public double getSweetenedProductsinGrams() {
		return energyNeeds * 0.1 / 17.0;
	}
	
	
	/**
	 * Add an observer to the MealRepartition class
	 * @param o, The new Observer to add.
	 */
	public void setObservers(Observer o) {
		this.addObserver(o);
	}
	
	
	public void displayObservers() {
		setChanged();
		notifyObservers(getClass());
	}
}
