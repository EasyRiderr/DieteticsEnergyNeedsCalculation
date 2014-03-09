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


	/**
	 * Notify the model that meal repartition values have been changed.
	 * @param mr, the new MealRepartition.
	 * @throws BadCarbohydratePercentageException, The carbohydrate percentage must be between 50% and 55%.
	 * @throws BadLipidPercentageException, The lipid percentage must be between 35% and 40%.
	 * @throws BadProteinPercentageException, The protein percentage must be between 12% and 15%.
	 * @throws PercentageMisallocationException, The sum of proteins, lipids and carbohydrate percentages must be equal to 100%.
	 */
	public void notifyMealRepartitionChanged(MealRepartition mr) throws BadCarbohydratePercentageException, BadLipidPercentageException, BadProteinPercentageException, PercentageMisallocationException {
		model.setCarbohydratePercentage(mr.getCarbohydratePercentage());
		model.setLipidPercentage(mr.getLipidPercentage());
		model.setProteinPercentage(mr.getProteinPercentage());
		model.setTakeASnack(mr.isTakeASnack());
		model.checkRepartition();
		
		view.close();
	}
}
