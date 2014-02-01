/*
 * DieteticsEnergyNeedsCalculation.java
 * 
 * Launch the Dietetics needs energy calculation application.
 * 29/01/2014 
 */


package controller;

import model.Metabolism;


/**
 * Launch the Dietetics needs energy calculation application.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class DieteticsEnergyNeedsCalculation {

	
	/**
	 * The main function.
	 * @param args
	 */
	public static void main(String[] args) {
		Metabolism m = new Metabolism();
		MetabolismController mc = new MetabolismController(m);
		mc.display();
	}
}
