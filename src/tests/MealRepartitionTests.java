/*
 * MealRepartitionTests.java
 * 
 * Test the MealRepartition class.
 * 28/02/2014 
 */


package tests;

import static org.junit.Assert.*;
import model.mealRepartition.BadCarbohydratePercentageException;
import model.mealRepartition.BadLipidPercentageException;
import model.mealRepartition.BadProteinPercentageException;
import model.mealRepartition.Meal;
import model.mealRepartition.MealRepartition;
import model.mealRepartition.PercentageMisallocationException;
import org.junit.Test;


/**
 * Test the MealRepartition class.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class MealRepartitionTests {
	
	
	@Test
	public void testCarbohydratePercentage() {
		MealRepartition mr = new MealRepartition();
		try {
			mr.setCarbohydratePercentage(0.49);
			fail("A BadCarbohydratePercentageException should have been thrown.");
		} catch (BadCarbohydratePercentageException e) {}
		try {
			mr.setCarbohydratePercentage(0.56);
			fail("A BadCarbohydratePercentageException should have been thrown.");
		} catch(BadCarbohydratePercentageException e) {};
		try {
			mr.setCarbohydratePercentage(0.53);
		} catch(BadCarbohydratePercentageException e) {
			fail("A BadCarbohydratePercentageException has been thrown.");
		}
	}
	
	
	@Test
	public void testLipidPercentage() {
		MealRepartition mr = new MealRepartition();
		try {
			mr.setLipidPercentage(0.34);
			fail("A BadLipidPercentageException should have been thrown.");
		} catch (BadLipidPercentageException e) {}
		try {
			mr.setLipidPercentage(0.41);
			fail("A BadLipidPercentageException should have been thrown.");
		} catch(BadLipidPercentageException e) {};
		try {
			mr.setLipidPercentage(0.35);
		} catch(BadLipidPercentageException e) {
			fail("A BadLipidPercentageException has been thrown.");
		}
	}
	
	
	@Test
	public void testProteinPercentage() {
		MealRepartition mr = new MealRepartition();
		try {
			mr.setProteinPercentage(0.11);
			fail("A BadProteinPercentageException should have been thrown.");
		} catch (BadProteinPercentageException e) {}
		try {
			mr.setProteinPercentage(0.16);
			fail("A BadProteinPercentageException should have been thrown.");
		} catch(BadProteinPercentageException e) {};
		try {
			mr.setProteinPercentage(0.15);
		} catch(BadProteinPercentageException e) {
			fail("A BadProteinPercentageException has been thrown.");
		}
	}
	
	
	@Test
	public void testcheckRepartition() {
		try {
			@SuppressWarnings("unused")
			MealRepartition mr = new MealRepartition(0.5, 0.35, 0.15, true, 4000);
		} catch (BadCarbohydratePercentageException
				| BadLipidPercentageException | BadProteinPercentageException e) {
			fail("Unexpectd exception catch !");
		} catch(PercentageMisallocationException e) {
			fail("A PercentageMisallocationException has been thrown !");
		}
		try {
			@SuppressWarnings("unused")
			MealRepartition mr = new MealRepartition(0.5, 0.37, 0.15, true, 4000);
			fail("A PercentageMisallocationException should have been thrown !");
		} catch (BadCarbohydratePercentageException
				| BadLipidPercentageException | BadProteinPercentageException e) {
			fail("Unexpectd exception catch !");
		} catch(PercentageMisallocationException e) {}
	}
	
	
	@Test
	public void testGetAnimalProteinsInGrams() {
		MealRepartition mr = new MealRepartition();
		//TODO calculer les valeur
		assertEquals(-999999995.88, mr.getAnimalProteinsInGrams(Meal.Breakfast), 0.01);
		assertEquals(-999999995.88, mr.getAnimalProteinsInGrams(Meal.Dinner), 0.01);
		assertEquals(-999999995.88, mr.getAnimalProteinsInGrams(Meal.DinnerWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getAnimalProteinsInGrams(Meal.Lunch), 0.01);
		assertEquals(-999999995.88, mr.getAnimalProteinsInGrams(Meal.LunchWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getAnimalProteinsInGrams(Meal.Snack), 0.01);
	}
	
	
	@Test
	public void testGetVegetableProteinsInGrams() {
		MealRepartition mr = new MealRepartition();
		//TODO calculer les valeur
		assertEquals(-999999995.88, mr.getVegetableProteinsInGrams(Meal.Breakfast), 0.01);
		assertEquals(-999999995.88, mr.getVegetableProteinsInGrams(Meal.Dinner), 0.01);
		assertEquals(-999999995.88, mr.getVegetableProteinsInGrams(Meal.DinnerWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getVegetableProteinsInGrams(Meal.Lunch), 0.01);
		assertEquals(-999999995.88, mr.getVegetableProteinsInGrams(Meal.LunchWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getVegetableProteinsInGrams(Meal.Snack), 0.01);
	}
	
	
	@Test
	public void testGetAnimalLipidInGrams() {
		MealRepartition mr = new MealRepartition();
		//TODO calculer les valeur
		assertEquals(-999999995.88, mr.getAnimalLipidInGrams(Meal.Breakfast), 0.01);
		assertEquals(-999999995.88, mr.getAnimalLipidInGrams(Meal.Dinner), 0.01);
		assertEquals(-999999995.88, mr.getAnimalLipidInGrams(Meal.DinnerWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getAnimalLipidInGrams(Meal.Lunch), 0.01);
		assertEquals(-999999995.88, mr.getAnimalLipidInGrams(Meal.LunchWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getAnimalLipidInGrams(Meal.Snack), 0.01);
	}
	
	
	@Test
	public void testGetVegetableLipidInGrams() {
		MealRepartition mr = new MealRepartition();
		//TODO calculer les valeur
		assertEquals(-999999995.88, mr.getVegetableLipidInGrams(Meal.Breakfast), 0.01);
		assertEquals(-999999995.88, mr.getVegetableLipidInGrams(Meal.Dinner), 0.01);
		assertEquals(-999999995.88, mr.getVegetableLipidInGrams(Meal.DinnerWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getVegetableLipidInGrams(Meal.Lunch), 0.01);
		assertEquals(-999999995.88, mr.getVegetableLipidInGrams(Meal.LunchWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getVegetableLipidInGrams(Meal.Snack), 0.01);
	}
	
	
	@Test
	public void testGetComplexCarbohydrate() {
		MealRepartition mr = new MealRepartition();
		//TODO calculer les valeur
		assertEquals(-999999995.88, mr.getComplexCarbohydrate(Meal.Breakfast), 0.01);
		assertEquals(-999999995.88, mr.getComplexCarbohydrate(Meal.Dinner), 0.01);
		assertEquals(-999999995.88, mr.getComplexCarbohydrate(Meal.DinnerWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getComplexCarbohydrate(Meal.Lunch), 0.01);
		assertEquals(-999999995.88, mr.getComplexCarbohydrate(Meal.LunchWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getComplexCarbohydrate(Meal.Snack), 0.01);
	}
	
	
	@Test
	public void testGetSimpleCarbohydrate() {
		MealRepartition mr = new MealRepartition();
		//TODO calculer les valeur
		assertEquals(-999999995.88, mr.getSimpleCarbohydrate(Meal.Breakfast), 0.01);
		assertEquals(-999999995.88, mr.getSimpleCarbohydrate(Meal.Dinner), 0.01);
		assertEquals(-999999995.88, mr.getSimpleCarbohydrate(Meal.DinnerWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getSimpleCarbohydrate(Meal.Lunch), 0.01);
		assertEquals(-999999995.88, mr.getSimpleCarbohydrate(Meal.LunchWithoutSnack), 0.01);
		assertEquals(-999999995.88, mr.getSimpleCarbohydrate(Meal.Snack), 0.01);
	}
	
	
	@Test
	public void testSweetenedProductsInGrams() {
		MealRepartition mr = new MealRepartition();
		// TODO calculer la valeur
		assertEquals(-999999995.88, mr.getSweetenedProductsinGrams(), 0.01);
	}

}
