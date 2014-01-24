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

	@Test
	public void testBMR() {
		double w = 56.d;
		int a = 19;
		double h = 1.6;
		Gender g = Gender.Female;
		
		// Assert the result of base metabolic rate is correct
		assertEquals(5.74, EnergyNeedsCalculations.getBMR(w, a, h, g), 0.01);
	}

}
