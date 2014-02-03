/*
 * MetabolismGUI.java
 * 
 * The GUI representing the Metabolism.
 * 29/01/2014 
 */


package view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.MetabolismController;
import model.Gender;
import model.Metabolism;


/**
 * The GUI representing the Metabolism.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Metabolism
 */
public class MetabolismGUI implements ActionListener {


	/** The frame of the GUI. */
	private JFrame frame;

	/** The OK button. */
	private JButton okBtn;


	/** The text field for the age of the patient. */
	private JTextField ageTextField;
	private JLabel ageLabel;


	/** The text field for the weight of the patient. */
	private JTextField weightTextField;
	private JLabel weightLabel;


	/** The text field for the height of the patient. */
	private JTextField heightTextField;
	private JLabel heightLabel;


	/** The text field for the level of physical activities of the patient. */
	private JTextField lpaTextField;
	private JLabel lpaLabel;


	/** The button group allowing to know the gender of the patient. */
	private ButtonGroup bg = new ButtonGroup();


	/** Radio buttons to choose the gender of the patient. */
	private JRadioButton femaleButton;
	private JRadioButton maleButton;


	/** The controller of the GUI. */
	private MetabolismController controller;


	/**
	 * Constructor of MetabolismGUI.
	 * @param ctrlr, The controller of the GUI.
	 * @param metabolism, The metabolism to represent.
	 */
	public MetabolismGUI(MetabolismController controller) {

		this.controller = controller;

		createContent();
	}


	/**
	 * Create the content of the view.
	 */
	private void createContent() {
		// TODO refaire le layout...
		// Set properties to the frame
		frame = new JFrame("Dietetics Energy needs calcultaion.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		frame.setLocationRelativeTo(null);
		GridBagConstraints c = new GridBagConstraints();
		Container container = frame.getContentPane();

		// Add Radio buttons
		femaleButton = new JRadioButton();
		bg.add(femaleButton);
		c.gridx = 0;
		c.gridy = 0;
		container.add(femaleButton, c);
		maleButton = new JRadioButton();
		bg.add(maleButton);
		c.gridx = 2;
		c.gridy = 0;
		container.add(maleButton, c);

		// Add images to the JRadio
		JLabel femaleImg = new JLabel(new ImageIcon("img/femaleSign.jpg"));
		c.gridx = 1;
		container.add(femaleImg, c);
		JLabel maleImg = new JLabel(new ImageIcon("img/maleSign.jpg"));
		c.gridx = 3;
		container.add(maleImg, c);

		// Add the age field
		ageLabel = new JLabel("Age : ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		container.add(ageLabel, c);
		ageTextField = new JTextField(5);
		c.gridx = 2;
		container.add(ageTextField, c);

		// Add the weight fields.
		weightLabel = new JLabel("Weight : ");
		c.gridx = 0;
		c.gridy = 2;
		container.add(weightLabel, c);
		weightTextField = new JTextField(5);
		c.gridx = 2;
		container.add(weightTextField, c);

		// Add the height fields
		heightLabel = new JLabel("Height : ");
		c.gridx = 0;
		c.gridy = 3;
		container.add(heightLabel, c);
		heightTextField = new JTextField(5);
		c.gridx = 2;
		container.add(heightTextField, c);

		// Add the level of physical activities fields
		lpaLabel = new JLabel("Level of physical activies : ");
		c.gridx = 0;
		c.gridy = 4;
		container.add(lpaLabel, c);
		lpaTextField = new JTextField(5);
		c.gridx = 2;
		container.add(lpaTextField, c);


		// Add the Ok button to the frame
		okBtn = new JButton("Ok");
		okBtn.addActionListener(this);
		c.gridx = 3;
		c.gridy = 5;
		container.add(okBtn, c);

		frame.pack();
	}


	private Metabolism getUserData() {
		// Get data from user
		if(!femaleButton.isSelected() && !maleButton.isSelected()) {
			JOptionPane.showMessageDialog(frame, "You must select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		Gender gender = femaleButton.isSelected()? Gender.Female : Gender.Male;
		int age = 0;
		try {
			age = Integer.parseInt(ageTextField.getText());
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(frame, "The age must be an integer.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		double height, weight, lpa;
		try {
			height = Double.parseDouble(heightTextField.getText());
			weight = Double.parseDouble(weightTextField.getText());
			lpa = Double.parseDouble(lpaTextField.getText());
		} catch(NumberFormatException ex2) {
			JOptionPane.showMessageDialog(frame, "The weight, the height and the level of physical activities must be a double.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		// Notify model of changes
		Metabolism m = null;
		try {
			m = new Metabolism(weight, height, age, gender, lpa);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return m;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Metabolism m = getUserData();
		if(m != null) {
			try {
				controller.notifyMetabolismChanged(m);
				close();
			} catch(Exception exc) {
				JOptionPane.showMessageDialog(frame, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	/**
	 * Displays the view.
	 */
	public void display() {
		frame.setVisible(true);
	}


	/**
	 * Close the view.
	 */
	public void close() {
		frame.dispose();
	}

}
