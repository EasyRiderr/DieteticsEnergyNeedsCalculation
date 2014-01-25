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
		assertEquals(1433.8, EnergyNeedsCalculations.getTotalNRJIntake(femaleEnergyNeeds_, Meal.Breakfast), 0.1);
		assertEquals(2007.4, EnergyNeedsCalculations.getTotalNRJIntake(femaleEnergyNeeds_, Meal.Lunch), 0.1);
		assertEquals(2294.2, EnergyNeedsCalculations.getTotalNRJIntake(femaleEnergyNeeds_, Meal.LunchWithoutSnack), 0.1);
		assertEquals(1720.6, EnergyNeedsCalculations.getTotalNRJIntake(femaleEnergyNeeds_, Meal.Dinner), 0.1);
		assertEquals(2007.4, EnergyNeedsCalculations.getTotalNRJIntake(femaleEnergyNeeds_, Meal.DinnerWithoutSnack), 0.1);
		assertEquals(573.5, EnergyNeedsCalculations.getTotalNRJIntake(femaleEnergyNeeds_, Meal.Snack), 0.1);
	}
	
	
	@Test
	public void testMaleNRJNeedsByMeal() {
		
		// Assert the result of energy needs by meal is correct
		assertEquals(1696.0, EnergyNeedsCalculations.getTotalNRJIntake(maleEnergyNeeds_, Meal.Breakfast), 0.1);
		assertEquals(2374.4, EnergyNeedsCalculations.getTotalNRJIntake(maleEnergyNeeds_, Meal.Lunch), 0.1);
		assertEquals(2713.6, EnergyNeedsCalculations.getTotalNRJIntake(maleEnergyNeeds_, Meal.LunchWithoutSnack), 0.1);
		assertEquals(2035.2, EnergyNeedsCalculations.getTotalNRJIntake(maleEnergyNeeds_, Meal.Dinner), 0.1);
		assertEquals(2374.4, EnergyNeedsCalculations.getTotalNRJIntake(maleEnergyNeeds_, Meal.DinnerWithoutSnack), 0.1);
		assertEquals(678.4, EnergyNeedsCalculations.getTotalNRJIntake(maleEnergyNeeds_, Meal.Snack), 0.1);
	}

}
