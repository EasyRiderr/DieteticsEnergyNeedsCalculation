/*
 * MetabolismTests.java
 * 
 * Test the Metabolism class.
 * 27/01/2014 
 */


package tests;

import static org.junit.Assert.*;
import model.Gender;
import model.Metabolism;
import model.exception.metabolism.IncoherentAgeException;
import model.exception.metabolism.IncoherentHeightException;
import model.exception.metabolism.IncoherentLpaException;
import model.exception.metabolism.IncoherentWeightException;

import org.junit.Test;


/**
 * Test the Metabolism class.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class MetabolismTests {

	@Test
	public void testWeightLimits() {
		Metabolism m = new Metabolism();
		try {
			m.setWeight(0);
			fail("An IncoherentWeightException should have been thrown.");
		} catch(IncoherentWeightException e) {}
		try {
			m.setWeight(-12.3);
			fail("An IncoherentWeightException should have been thrown.");
		} catch(IncoherentWeightException e) {}
		try {
			m.setWeight(501);
			fail("An IncoherentWeightException should have been thrown.");
		} catch(IncoherentWeightException e) {}
		try {
			m.setWeight(60);
		} catch(IncoherentWeightException e) {
			fail("An IncoherentWeightException has been thrown.");
		}
	}
	
	
	@Test
	public void testAgeLimits() {
		Metabolism m = new Metabolism();
		try {
			m.setAge(0);
			fail("An IncoherentAgeException should have been thrown.");
		} catch(IncoherentAgeException e) {}
		try {
			m.setAge(-12);
			fail("An IncoherentAgeException should have been thrown.");
		} catch(IncoherentAgeException e) {}
		try {
			m.setAge(175);
			fail("An IncoherentAgeException should have been thrown.");
		} catch(IncoherentAgeException e) {}
		try {
			m.setAge(19);
		} catch(IncoherentAgeException e) {
			fail("An IncoherentAgeException has been thrown.");
		}
	}

	
	@Test
	public void testHeightLimits() {
		Metabolism m = new Metabolism();
		try {
			m.setHeight(0.);
			fail("An IncoherentHeightException should have been thrown.");
		} catch(IncoherentHeightException e) {}
		try {
			m.setHeight(-1.);
			fail("An IncoherentHeightException should have been thrown.");
		} catch(IncoherentHeightException e) {}
		try {
			m.setHeight(3.1);
			fail("An IncoherentHeightException should have been thrown.");
		} catch(IncoherentHeightException e) {}
		try {
			m.setHeight(1.6);
		} catch(IncoherentHeightException e) {
			fail("An IncoherentHeightException has been thrown.");
		}
	}
	
	
	@Test
	public void testLpaLimits() {
		Metabolism m = new Metabolism();
		try {
			m.setLpa(0.);
		} catch(IncoherentLpaException e) {
			fail("An IncoherentLpaException has been thrown.");
		}
		try {
			m.setLpa(-1.);
			fail("An IncoherentLpaException should have been thrown.");
		} catch(IncoherentLpaException e) {}
		try {
			m.setLpa(3.1);
			fail("An IncoherentLpaException should have been thrown.");
		} catch(IncoherentLpaException e) {}
		try {
			m.setLpa(1.);
		} catch(IncoherentLpaException e) {
			fail("An IncoherentLpaException has been thrown.");
		}
	}

	
	@Test
	public void testFemaleBMR() {
		try {
			Metabolism m = new Metabolism(56, 1.6, 19, Gender.Female, 1);
			assertEquals(5.7355, m.getBMR(), 0.0001);
		} catch(Exception e) {
			fail("Values of the metabolism aren't correct.");
		}
	}
	
	
	@Test
	public void testMaleBMR() {
		try {
			Metabolism m = new Metabolism(56, 1.86, 23, Gender.Male, 1);
			assertEquals(6.7840, m.getBMR(), 0.0001);
		} catch(Exception e) {
			fail("Values of the metabolism aren't correct.");
		}
	}
	
	
	@Test
	public void testFemaleEnergyNeeds() {
		try {
			Metabolism m = new Metabolism(56, 1.6, 19, Gender.Female, 1);
			assertEquals(5735.5, m.getEnergyNeeds(), 0.1);
		} catch(Exception e) {
			fail("Values of the metabolism aren't correct.");
		}
	}
	
	
	@Test
	public void testMaleEnergyNeeds() {
		try {
			Metabolism m = new Metabolism(56, 1.86, 23, Gender.Male, 1);
			assertEquals(6784, m.getEnergyNeeds(), 0.1);
		} catch(Exception e) {
			fail("Values of the metabolism aren't correct.");
		}
	}
}
