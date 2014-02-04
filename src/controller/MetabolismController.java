/*
 * MetabolismController.java
 * 
 * Control actions between the views and the Metabolism model.
 * 01/02/2014 
 */


package controller;

import model.metabolism.IncoherentAgeException;
import model.metabolism.IncoherentHeightException;
import model.metabolism.IncoherentLpaException;
import model.metabolism.IncoherentWeightException;
import model.metabolism.Metabolism;
import view.MetabolismGUI;


/**
 * Control actions between the views and the Metabolism model.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 */
public class MetabolismController {

	
	/** The view of metabolsim. */
	private MetabolismGUI view;
	
	
	/** The model to control. */
	private Metabolism model;
	
	
	/**
	 * Constructor of controller of metabolism.
	 * @param model, The model to control.
	 */
	public MetabolismController(Metabolism model) {
		this.model = model;
		
		view = new MetabolismGUI(this);
	}
	
	
	/**
	 * Notify the model that metabolism values have been changed.
	 * @param metabolism, The new metabolism.
	 * @throws IncoherentWeightException if the weight of the patient is not between 0 and 500kgs.
	 * @throws IncoherentAgeException if the age of the patient is not between 0 and 150 years.
	 * @throws IncoherentHeightException if the height of the patient is not between 0 and 3m.
	 * @throws IncoherentLpaException if the level of physical activities of the patient is not between 0 and 2.
	 */
	public void notifyMetabolismChanged(Metabolism metabolism) throws IncoherentWeightException, IncoherentAgeException, IncoherentHeightException, IncoherentLpaException {
		model.setWeight(metabolism.getWeight());
		model.setAge(metabolism.getAge());
		model.setGender(metabolism.getGender());
		model.setHeight(metabolism.getHeight());
		model.setLpa(metabolism.getLpa());
	}
	
	
	/**
	 * Display the view of the metabolism.
	 */
	public void display() {
		view.display();
	}
	
	
	/**
	 * Close the view of the metabolism.
	 */
	public void close() {
		view.close();
	}
}
