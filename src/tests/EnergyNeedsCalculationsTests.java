/*
 * EnergyNeedsCalculationsTests.java
 * 
 * Permits to test methods of EnergyNeedsCalculations.
 * 
 * 24/01/2014 
 */


package tests;


import static org.junit.Assert.*;
import model.EnergyNeedsCalculations;
import model.Gender;
import model.Meal;
import model.exception.BadCarbohydratePercentageException;
import model.exception.BadLipidPercentageException;
import model.exception.BadProteinPercentageException;

import org.junit.Test;


/**
 * Permits to test methods of EnergyNeedsCalculations.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class EnergyNeedsCalculationsTests {

	
	private double femaleBMR_ = EnergyNeedsCalculations.getBMR(56, 19, 1.6, Gender.Female);
	private double maleBMR_ = EnergyNeedsCalculations.getBMR(56, 23, 1.86, Gender.Male);
	
	private double femaleEnergyNeeds_ = EnergyNeedsCalculations.getEnergyNeeds(femaleBMR_, 1);
	private double maleEnergyNeeds_ = EnergyNeedsCalculations.getEnergyNeeds(maleBMR_, 1);
	
	
	@Test
	public void testFemaleBMR() {
		
		// Assert the result of base metabolic rate is correct
		assertEquals(5.7355, femaleBMR_, 0.0001);
	}
	
	
	@Test
	public void testMaleBMR() {
		
		// Assert the result of base metabolic rate is correct
		assertEquals(6.7840, maleBMR_, 0.0001);
	}
	
	
	@Test
	public void testFemaleEnergyNeeds() {
		
		// Assert the result of female energy needs is correct
		assertEquals(5735.5, femaleEnergyNeeds_, 0.1);
	}
	
	
	@Test
	public void testMaleEnergyNeeds() {
		
		// Assert the result of male energy needs is correct
		assertEquals(6784, maleEnergyNeeds_, 0.1);
	}
	
	
	@Test
	public void testFemaleNRJNeedsByMeal() {
		
		// Assert the result of energy needs by meal is correct
		assertEquals(1433.8, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(femaleEnergyNeeds_, Meal.Breakfast), 0.1);
		assertEquals(2007.4, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(femaleEnergyNeeds_, Meal.Lunch), 0.1);
		assertEquals(2294.2, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(femaleEnergyNeeds_, Meal.LunchWithoutSnack), 0.1);
		assertEquals(1720.6, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(femaleEnergyNeeds_, Meal.Dinner), 0.1);
		assertEquals(2007.4, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(femaleEnergyNeeds_, Meal.DinnerWithoutSnack), 0.1);
		assertEquals(573.5, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(femaleEnergyNeeds_, Meal.Snack), 0.1);
	}
	
	
	@Test
	public void testMaleNRJNeedsByMeal() {
		
		// Assert the result of energy needs by meal is correct
		assertEquals(1696.0, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(maleEnergyNeeds_, Meal.Breakfast), 0.1);
		assertEquals(2374.4, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(maleEnergyNeeds_, Meal.Lunch), 0.1);
		assertEquals(2713.6, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(maleEnergyNeeds_, Meal.LunchWithoutSnack), 0.1);
		assertEquals(2035.2, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(maleEnergyNeeds_, Meal.Dinner), 0.1);
		assertEquals(2374.4, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(maleEnergyNeeds_, Meal.DinnerWithoutSnack), 0.1);
		assertEquals(678.4, EnergyNeedsCalculations.getTotalNRJIntakeNeeds(maleEnergyNeeds_, Meal.Snack), 0.1);
	}
	
	
	@Test
	public void testAnimalProteinsInGrams() {
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getAnimalProteinsInGrams(1000.0, 0.1), 0.1);
			fail("A BadProteinPercentageException should have been thrown.");
		} catch(BadProteinPercentageException e) {
		}
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getAnimalProteinsInGrams(1000.0, 0.16), 0.1);
			fail("A BadProteinPercentageException should have been thrown.");
		} catch(BadProteinPercentageException e) {
		}
		try {
			assertEquals(4.41, EnergyNeedsCalculations.getAnimalProteinsInGrams(1000.0, 0.15), 0.01);
		} catch(BadProteinPercentageException e) {
			fail("A BadProteinPercentageException has been catched.");
		}
	}
	
	
	@Test
	public void testVegetableProteinsInGrams() {
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getVegetableProteinsInGrams(1000.0, 0.1), 0.1);
			fail("A BadProteinPercentageException should have been thrown.");
		} catch(BadProteinPercentageException e) {
		}
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getVegetableProteinsInGrams(1000.0, 0.16), 0.1);
			fail("A BadProteinPercentageException should have been thrown.");
		} catch(BadProteinPercentageException e) {
		}
		try {
			assertEquals(4.41, EnergyNeedsCalculations.getVegetableProteinsInGrams(1000.0, 0.15), 0.01);
		} catch(BadProteinPercentageException e) {
			fail("A BadProteinPercentageException has been catched.");
		}
	}
	
	
	@Test
	public void testAnimalLipidInGrams() {
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getAnimalLipidInGrams(1000.0, 0.34), 0.1);
			fail("A BadLipidPercentageException should have been thrown.");
		} catch(BadLipidPercentageException e) {
		}
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getAnimalLipidInGrams(1000.0, 0.41), 0.1);
			fail("A BadLipidPercentageException should have been thrown.");
		} catch(BadLipidPercentageException e) {
		}
		try {
			assertEquals(4.61, EnergyNeedsCalculations.getAnimalLipidInGrams(1000.0, 0.35), 0.01);
		} catch(BadLipidPercentageException e) {
			fail("A BadLipidPercentageException has been catched.");
		}
	}
	
	
	@Test
	public void testVegetableLipidInGrams() {
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getVegetableLipidInGrams(1000.0, 0.34), 0.1);
			fail("A BadLipidPercentageException should have been thrown.");
		} catch(BadLipidPercentageException e) {
		}
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getVegetableLipidInGrams(1000.0, 0.41), 0.1);
			fail("A BadLipidPercentageException should have been thrown.");
		} catch(BadLipidPercentageException e) {
		}
		try {
			assertEquals(4.61, EnergyNeedsCalculations.getVegetableLipidInGrams(1000.0, 0.35), 0.01);
		} catch(BadLipidPercentageException e) {
			fail("A BadLipidPercentageException has been catched.");
		}
	}
	
	
	@Test
	public void testComplexCarbohydrateInGrams() {
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getComplexCarbohydrate(1000.0, 0.49), 0.1);
			fail("A BadCarbohydratePercentageException should have been thrown.");
		} catch(BadCarbohydratePercentageException e) {
		}
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getComplexCarbohydrate(1000.0, 0.56), 0.1);
			fail("A BadCarbohydratePercentageException should have been thrown.");
		} catch(BadCarbohydratePercentageException e) {
		}
		try {
			assertEquals(16.18, EnergyNeedsCalculations.getComplexCarbohydrate(1000.0, 0.50), 0.01);
		} catch(BadCarbohydratePercentageException e) {
			fail("A BadCarbohydratePercentageException has been catched.");
		}
	}
	
	
	@Test
	public void testSimpleCarbohydrateInGrams() {
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getSimpleCarbohydrate(1000.0, 0.49), 0.1);
			fail("A BadCarbohydratePercentageException should have been thrown.");
		} catch(BadCarbohydratePercentageException e) {
		}
		try {
			assertEquals(2.0, EnergyNeedsCalculations.getSimpleCarbohydrate(1000.0, 0.56), 0.1);
			fail("A BadCarbohydratePercentageException should have been thrown.");
		} catch(BadCarbohydratePercentageException e) {
		}
		try {
			assertEquals(13.24, EnergyNeedsCalculations.getSimpleCarbohydrate(1000.0, 0.50), 0.01);
		} catch(BadCarbohydratePercentageException e) {
			fail("A BadCarbohydratePercentageException has been catched.");
		}
	}
	
	
	@Test
	public void testSweetenedProductsInGrams() {
		assertEquals(5.88, EnergyNeedsCalculations.getSweetenedProductsinGrams(1000), 0.01);
	}

}
