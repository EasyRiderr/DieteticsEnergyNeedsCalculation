/*
 * MetabolismController.java
 * 
 * Control actions between the views and the Metabolism model.
 * 01/02/2014 
 */


package controller;

import model.Metabolism;
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
		model.addObserver(view);
	}
	
	
	/**
	 * Notify the model that metabolism values have been changed.
	 * @param metabolism, The new metabolism.
	 */
	public void notifyMetabolismChanged(Metabolism metabolism) {
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
