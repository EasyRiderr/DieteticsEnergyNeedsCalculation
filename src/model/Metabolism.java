/*
 * Metabolism.java
 * 
 * Represent the metabolism of a patient.
 * 27/01/2014 
 */


package model;

import javax.swing.event.EventListenerList;

import model.eventListeners.MetabolismListener;
import model.eventObject.MetabolismChangedEvent;


/**
 * Metabolism represent the metabolism of patients.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Gender
 */
public class Metabolism {

	
	/** The weight of the patient. */
	private double weight;
	
	
	/** The age of the patient. */
	private double age;
	
	
	/** The height if the patient. */
	private double height;
	
	
	/** The Gender of the patient. */
	private Gender gender;
	
	
	/** The level of physical activites. */
	private double lpa;
	
	
	/** The list of listeners */
	private EventListenerList listeners;
	
	
	/**
	 * Default constructor of Metabolism.
	 */
	public Metabolism() {
		this(56., 1.60, 19, Gender.Female, 1);
	}
	
	
	/**
	 * Constructor of Metabolism.
	 * @param weight, The weight of the patient.
	 * @param height, The height of the patient.
	 * @param age, The age of the patient.
	 * @param gender, The Gender of the patient.
	 * @param lpa, The level of physical activities of the patient.
	 */
	public Metabolism(double weight, double height, double age, Gender gender, double lpa) {
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.gender = gender;
		this.lpa = lpa;
		
		listeners = new EventListenerList();
	}


	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
		
		fireMetabolismChanged();
	}


	/**
	 * @return the age
	 */
	public double getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(double age) {
		this.age = age;
		
		fireMetabolismChanged();
	}


	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
		
		fireMetabolismChanged();
	}


	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
		
		fireMetabolismChanged();
	}


	/**
	 * @return the lpa
	 */
	public double getLpa() {
		return lpa;
	}


	/**
	 * @param lpa the lpa to set
	 */
	public void setLpa(double lpa) {
		this.lpa = lpa;
		
		fireMetabolismChanged();
	}
	
	
	/**
	 * @return the metabolism
	 */
	public Metabolism getMetabolism() {
		return this;
	}
	
	
	/**
	 * @param metabolism the metabolism to set
	 */
	public void setMetabolism(Metabolism metabolism) {
		weight = metabolism.weight;
		age = metabolism.age;
		height = metabolism.height;
		gender = metabolism.gender;
		
		fireMetabolismChanged();
	}
	
	
	/**
	 * Add a listener to the list of listeners.
	 * @param listener, The listener to add to the list.
	 */
	public void addMetabolismListener(MetabolismListener listener){
		listeners.add(MetabolismListener.class, listener);
	}
 
	
	/**
	 * Remove a listener to the list of listener.
	 * @param listener, The listener to remove of the list.
	 */
	public void removeMetabolismListener(MetabolismListener listener){
		 listeners.remove(MetabolismListener.class, listener);
	}
 
	
	/**
	 * Update the value of Metabolism.
	 */
	public void fireMetabolismChanged(){
		MetabolismListener[] listenerList = (MetabolismListener[])listeners.getListeners(MetabolismListener.class);
 
		for(MetabolismListener listener : listenerList){
			listener.metabolismChanged(new MetabolismChangedEvent(this, getWeight(), getAge(), getHeight(), getGender()));
		}
	}
}
