/*
 * MealRepartitionController.java
 * 
 * Control actions between the views and the Meal repartition model.
 * 02/03/2014 
 */


package controller;

import model.mealRepartition.BadCarbohydratePercentageException;
import model.mealRepartition.BadLipidPercentageException;
import model.mealRepartition.BadProteinPercentageException;
import model.mealRepartition.MealRepartition;
import model.mealRepartition.PercentageMisallocationException;
import view.MealRepartitionGUI;


/**
 * Control actions between the views and the Meal repartition model.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class MealRepartitionController {

	/** The view of the meal repartition. */
	private MealRepartitionGUI view;
	
	/** The meal repartition model. */
	private MealRepartition model;
	
	
	/**
	 * Constructor of controller of meal repartition.
	 * @param model, The model to control.
	 */
	public MealRepartitionController(MealRepartition model) {
		this.model = model;
		
		view = new MealRepartitionGUI(this);
	}
	
	
	/**
	 * Notify the model that meal repartition values have been changed.
	 * @param carbohydratePercentage, The carbohydrate percentage wished for the meal.
	 * @param lipidPercentage, The lipid percentage wished for the meal.
	 * @param proteinPercentage, The protein percentage wished for the meal.
	 * @param takeASnack, Permit to know if the patient take a snack.
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 * @throws PercentageMisallocationException, The sum of proteins, lipids and carbohydrate percentages must be equal to 100%.
	 */
	public void notifyMealRepartitionChanged(double carbohydratePercentage, double lipidPercentage, double proteinPercentage, boolean takeASnack) throws BadCarbohydratePercentageException, BadLipidPercentageException, BadProteinPercentageException, PercentageMisallocationException {
		model.setCarbohydratePercentage(carbohydratePercentage);
		model.setLipidPercentage(lipidPercentage);
		model.setProteinPercentage(proteinPercentage);
		model.setTakeASnack(takeASnack);
		model.checkRepartition();
	}
	
	
	/**
	 * Display the meal repartition view.
	 */
	public void display() {
		view.display();
	}
	
	
	/**
	 * Close the meal repartition view.
	 */
	public void close() {
		view.close();
	}
}
