/*
 * MetabolismGUI.java
 *
 * The GUI representing the Metabolism.
 * 29/01/2014
 */


package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.MetabolismController;
import model.metabolism.Gender;
import model.metabolism.Metabolism;


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


	/** Panel to manage the layout of textfields and labels. */
	private JPanel tfPanel = new JPanel();

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

	/** The panel containing radio buttons and associated images. */
	private JPanel rbPanel = new JPanel();


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
		// Set properties to the frame
		frame = new JFrame("Dietetics Energy needs calculation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		Container container = frame.getContentPane();

		// Add Radio buttons
		femaleButton = new JRadioButton();
		bg.add(femaleButton);
		rbPanel.add(femaleButton);
		JLabel femaleImg = new JLabel(new ImageIcon(getClass().getResource("/femaleSign.jpg")));
		rbPanel.add(femaleImg);

		maleButton = new JRadioButton();
		bg.add(maleButton);
		rbPanel.add(maleButton);
		JLabel maleImg = new JLabel(new ImageIcon(getClass().getResource("/maleSign.jpg")));
		rbPanel.add(maleImg);
		container.add(rbPanel, BorderLayout.NORTH);

		tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.PAGE_AXIS));

		JPanel agePan = new JPanel();
		agePan.setLayout(new BoxLayout(agePan, BoxLayout.LINE_AXIS));
		// Add the age field
		ageLabel = new JLabel("Age : ");
		agePan.add(ageLabel);
		agePan.add(Box.createHorizontalGlue());
		ageTextField = new JTextField(3);
		ageTextField.setMaximumSize(new Dimension(10, 20));
		agePan.add(ageTextField);
		tfPanel.add(agePan);

		// Add the weight fields.
		JPanel weightPan = new JPanel();
		weightPan.setLayout(new BoxLayout(weightPan, BoxLayout.LINE_AXIS));
		weightLabel = new JLabel("Weight : ");
		weightPan.add(weightLabel);
		weightPan.add(Box.createHorizontalGlue());
		weightTextField = new JTextField(3);
		weightTextField.setMaximumSize(new Dimension(10, 20));
		weightPan.add(weightTextField);
		tfPanel.add(weightPan);

		// Add the height fields
		JPanel heightPan = new JPanel();
		heightPan.setLayout(new BoxLayout(heightPan, BoxLayout.LINE_AXIS));
		heightLabel = new JLabel("Height : ");
		heightPan.add(heightLabel);
		heightPan.add(Box.createHorizontalGlue());
		heightTextField = new JTextField(3);
		heightTextField.setMaximumSize(new Dimension(10, 20));
		heightPan.add(heightTextField);
		tfPanel.add(heightPan);

		// Add the level of physical activities fields
		JPanel lpaPanel = new JPanel();
		lpaPanel.setLayout(new BoxLayout(lpaPanel, BoxLayout.LINE_AXIS));
		lpaLabel = new JLabel("Level of physical activies : ");
		lpaPanel.add(lpaLabel);
		lpaPanel.add(Box.createHorizontalGlue());
		lpaTextField = new JTextField(3);
		lpaTextField.setMaximumSize(new Dimension(10, 20));
		lpaPanel.add(lpaTextField);
		tfPanel.add(lpaPanel);
		container.add(tfPanel, BorderLayout.CENTER);


		// Add the Ok button to the frame
		okBtn = new JButton("Ok");
		okBtn.addActionListener(this);
		container.add(okBtn, BorderLayout.SOUTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
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
