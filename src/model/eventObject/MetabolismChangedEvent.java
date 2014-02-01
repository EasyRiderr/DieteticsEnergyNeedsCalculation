/*
 * MetabolismChangedEvent.java
 * 
 * Represent an event which change Metabolism.
 * 27/01/2014 
 */


package model.eventObject;

import java.util.EventObject;

import model.Gender;
import model.Metabolism;


/**
 * MetabolismChangedEvent represent an event which change Metabolism.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Metabolism
 */
public class MetabolismChangedEvent extends EventObject {

	
	/** The ID of serialization. */
	private static final long serialVersionUID = 1L;
	
	
	/** The weight of the patient. */
	private double newWeight;
	
	
	/** The age of the patient. */
	private double newAge;
	
	
	/** The height if the patient. */
	private double newHeight;
	
	
	/** The Gender of the patient. */
	private Gender newGender;

	
	/**
	 * Constructor of MetabolismChangesEvent.
	 * @param source, The source of the event.
	 * @param newWeight, The new weight of the patient.
	 * @param newAge, The new age of the patient.
	 * @param newHeight, The new height of the patient.
	 * @param newGender, The new gender of the patient.
	 */
	public MetabolismChangedEvent(Object source, double newWeight, double newAge, double newHeight, Gender newGender) {
		super(source);
		this.newWeight = newWeight;
		this.newAge = newAge;
		this.newHeight = newHeight;
		this.newGender = newGender;
	}


	/**
	 * @return the newWeight
	 */
	public double getNewWeight() {
		return newWeight;
	}


	/**
	 * @return the newAge
	 */
	public double getNewAge() {
		return newAge;
	}


	/**
	 * @return the newHeight
	 */
	public double getNewHeight() {
		return newHeight;
	}


	/**
	 * @return the newGender
	 */
	public Gender getNewGender() {
		return newGender;
	}


	/**
	 * @return the newMetabolism
	 */
	public Metabolism getNewMetabolism() {
		return new Metabolism(newWeight, newHeight, newAge, newGender, 1);
	}

}
