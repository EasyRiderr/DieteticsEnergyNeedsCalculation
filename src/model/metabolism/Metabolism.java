/*
 * Metabolism.java
 * 
 * Represent the metabolism of a patient.
 * 27/01/2014 
 */


package model.metabolism;

import java.util.Observable;


/**
 * Metabolism represent the metabolism of patients.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Gender
 */
public class Metabolism extends Observable {


	/** The weight of the patient. */
	private double weight;


	/** The age of the patient. */
	private int age;


	/** The height if the patient. */
	private double height;


	/** The Gender of the patient. */
	private Gender gender;


	/** The level of physical activities. */
	private double lpa;


	/**
	 * Default constructor of Metabolism.
	 */
	public Metabolism() {
		try {
			setWeight(56);
			setHeight(1.6);
			setAge(19);
			setGender(Gender.Female);
			setLpa(1);
		} catch(Exception e) {

		}
	}


	/**
	 * Constructor of Metabolism.
	 * @param weight, The weight of the patient.
	 * @param height, The height of the patient.
	 * @param age, The age of the patient.
	 * @param gender, The Gender of the patient.
	 * @param lpa, The level of physical activities of the patient.
	 * @throws IncoherentWeightException if the weight of the patient is not between 0 and 500kgs.
	 * @throws IncoherentAgeException if the age of the patient is not between 0 and 150 years.
	 * @throws IncoherentHeightException if the height of the patient is not between 0 and 3m.
	 * @throws IncoherentLpaException if the level of physical activities of the patient is not between 0 and 2.
	 */
	public Metabolism(double weight, double height, int age, Gender gender, double lpa) throws IncoherentWeightException, IncoherentAgeException, IncoherentHeightException, IncoherentLpaException {
		setWeight(weight);
		setHeight(height);
		setAge(age);
		setGender(gender);
		setLpa(lpa);
	}


	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 * @throws IncoherentWeightException if the weight of the patient is not between 0 and 500kgs.
	 */
	public void setWeight(double weight) throws IncoherentWeightException {
		if(weight <= 0 || weight > 500) {
			throw new IncoherentWeightException("The weight of the patient must be between 0 and 500kgs.");
		}
		this.weight = weight;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 * @throws IncoherentAgeException if the age of the patient is not between 0 and 150 years.
	 */
	public void setAge(int age) throws IncoherentAgeException {
		if(age <= 0 || age > 150) {
			throw new IncoherentAgeException("The age of the patient must be between 0 and 150 years.");
		}
		this.age = age;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}


	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 * @throws IncoherentHeightException if the height of the patient is not between 0 and 3m.
	 */
	public void setHeight(double height) throws IncoherentHeightException {
		if(height <= 0 || height > 3) {
			throw new IncoherentHeightException("The height of the patient must be between 0 and 3m.");
		}
		this.height = height;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
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

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}


	/**
	 * @return the lpa
	 */
	public double getLpa() {
		return lpa;
	}


	/**
	 * @param lpa the lpa to set
	 * @throws IncoherentLpaException if the level of physical activities of the patient is not between 0 and 2.
	 */
	public void setLpa(double lpa) throws IncoherentLpaException {
		if(lpa < 0 || lpa > 2) {
			throw new IncoherentLpaException("The level of physical activities of the patient must be between 0 and 2.");
		}
		this.lpa = lpa;

		// Notify changes
		this.setChanged();
		this.notifyObservers(this);
	}
	
	
	/**
	 * Return the Basal Metabolic Rate of the patient.
	 * @param weight, The weight of the patient in kg.
	 * @param age, The age of the patient in years.
	 * @param height, The height of the patient in m.
	 * @param gender, The gender of the patient.
	 * @return The Basal Metabolic Rate of the patient.
	 */
	public double getBMR() {
		return gender.getGenderCoeff() * Math.pow(weight, 0.48) * Math.pow(height, 0.5) * Math.pow(age, -0.13);
	}
	
	
	/**
	 * Return the Energy needs of the patient.
	 * @param bmr, The Base Metabolic Rate of the patient.
	 * @param lpa, The level of physical activity of the patient.
	 * @return The energy needs of the patient in kJ.
	 */
	public double getEnergyNeeds() {
		return getBMR() * lpa * 1000;
	}
}
