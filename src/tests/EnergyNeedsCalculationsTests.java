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
		double lpa = 1.;
		
		// Assert the result of base metabolic rate is correct
		assertEquals(5735.5, EnergyNeedsCalculations.getEnergyNeeds(femaleBMR_, lpa), 0.1);
	}
	
	
	@Test
	public void testMaleEnergyNeeds() {
		double lpa = 1;
		
		// Assert the result of base metabolic rate is correct
		assertEquals(6784, EnergyNeedsCalculations.getEnergyNeeds(maleBMR_, lpa), 0.1);
	}

}
