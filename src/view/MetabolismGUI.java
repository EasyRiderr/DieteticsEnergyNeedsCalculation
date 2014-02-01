/*
 * MetabolismGUI.java
 * 
 * The GUI representing the Metabolism.
 * 29/01/2014 
 */


package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
public class MetabolismGUI implements ActionListener, Observer {

	
	/** The frame of the GUI. */
	private JFrame frame;
	
	/** The format of numbers. */
	private NumberFormat format;
	
	/** The OK button. */
	private JButton okBtn;
	
	
	/** The formated text field. */
	private JFormattedTextField textField;
	
	
	/** The label showing the value of the weight of the patient. */
	private JLabel label;
	
	
	/** The controller of the GUI. */
	private MetabolismController controller;
	
	
	/**
	 * Constructor of MetabolismGUI.
	 * @param ctrlr, The controller of the GUI.
	 * @param metabolism, The metabolism to represent.
	 */
	public MetabolismGUI(MetabolismController controller, Metabolism metabolism) {

		this.controller = controller;
		
		frame = new JFrame("Dietetics Energy needs calcultaion.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(false);
		format.setMaximumFractionDigits(2);
		format.setMaximumIntegerDigits(3);
		
		textField = new JFormattedTextField(format);
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		label = new JLabel("" + metabolism.getWeight());
		frame.getContentPane().add(label);
		
		okBtn = new JButton("Ok");
		okBtn.addActionListener(this);
		frame.getContentPane().add(okBtn);
		
		frame.pack();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Metabolism m = new Metabolism(Double.parseDouble(textField.getValue().toString()), 1.6, 19, Gender.Female, 1);
		controller.notifyMetabolismChanged(m);
	}


	@Override
	public void update(Observable o, Object arg) {
		label.setText("" + ((Metabolism)arg).getWeight());
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
