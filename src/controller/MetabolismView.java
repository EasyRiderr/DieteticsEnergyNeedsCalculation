/*
 * MetabolismView.java
 * 
 * Represent an abstract view of Metabolism to be the least dependent on Swing.
 * 28/01/2014 
 */


package controller;

import model.Metabolism;
import model.eventListeners.MetabolismListener;


/**
 * MetabolismView represent an abstract view of Metabolism to be the least dependent on Swing.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Metabolism
 */
public abstract class MetabolismView implements MetabolismListener {


	/** The controller of the view. */
	private MetabolismController controller = null;


	/**
	 * Constructor of MetabolsimView.
	 * @param ctrlr, The controller of the view.
	 */
	public MetabolismView(MetabolismController ctrlr) {
		super();
		this.controller = ctrlr;
	}


	/**
	 * Return the controller of the MetabolismView.
	 * @return The controller of the MetabolismView.
	 */
	public final MetabolismController getController() {
		return controller;
	}


	/**
	 * Diplays the MetabolismView.
	 */
	public abstract void display();
	
	
	/**
	 * Close the MetabolismView.
	 */
	public abstract void close();
}
