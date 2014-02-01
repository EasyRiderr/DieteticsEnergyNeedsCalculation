/*
 * MetabolismController.java
 * 
 * Control the MetabolismModel.
 * 28/01/2014 
 */


package controller;

import view.MetabolismGUI;
import model.Metabolism;


/**
 * Control the MetabolismModel.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Metabolism
 */
public class MetabolismController {

	
	/** The view to control. */
	private MetabolismView metabolismView;
	
	
	/** The Metabolism model. */
	private Metabolism model;
	
	
	/**
	 * Constructor of MetabolismController.
	 * @param model, The model to control.
	 */
	public MetabolismController(Metabolism model) {
		this.model = model;
		
		metabolismView = new MetabolismGUI(this, model.getMetabolism());
		
		// Add listeners
		model.addMetabolismListener(metabolismView);
	}
	
	
	/**
	 * Display the View.
	 */
	public void displayView() {
		metabolismView.display();
	}
	
	
	/**
	 * Close the View.
	 */
	public void closeView() {
		metabolismView.close();
	}
	
	
	/**
	 * Notify every views that metabolism have changed.
	 * @param metabolism, The new metabolism.
	 */
	public void notifyMetabolismChanged(Metabolism metabolism) {
		model.setMetabolism(metabolism);
	}
}
