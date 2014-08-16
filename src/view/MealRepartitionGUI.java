/*
 * MealRepartitionGUI.java
 *
 * The GUI representing the MealRepartition.
 * 28/02/2014
 */


package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.MealRepartitionController;
import model.mealRepartition.BadCarbohydratePercentageException;
import model.mealRepartition.BadLipidPercentageException;
import model.mealRepartition.BadProteinPercentageException;
import model.mealRepartition.MealRepartition;


/**
 * The GUI representing the MealRepartition.
 *
 * @author Yoan DUMAS
 * @version 1.0
 * @see MealRepartition
 */
public class MealRepartitionGUI implements ActionListener, FocusListener, ChangeListener {

	/** The frame of the GUI. */
	private JFrame frame;

	/** The OK button. */
	private JButton okBtn;

	/** The text field for the percentage of carbohydrate by meal. */
	private JTextField carbohydratePercentageTextField;
	private JLabel carbohydratePercentageLabel;
	private JSlider carbohydratePercentageSlider;

	/** The text field for the percentage of protein by meal. */
	private JTextField proteinPercentageTextField;
	private JLabel proteinPercentageLabel;
	private JSlider proteinPercentageSlider;

	/** The text field for the percentage of lipid by meal. */
	private JTextField lipidPercentageTextField;
	private JLabel lipidPercentageLabel;
	private JSlider lipidPercentageSlider;

	/** The check box to know if the patient take a snack . */
	private JLabel takeASnackLabel;
	private JCheckBox takeASnackCheckBox;

	/** The model controller of meal repartition to notify. */
	private MealRepartitionController controller;


	/**
	 * Constructor of meal repartition view.
	 * @param controller, The controller of meal repartition.
	 */
	public MealRepartitionGUI(MealRepartitionController controller) {
		this.controller = controller;

		createContent();
	}


	/**
	 * Create and add content to the GUI of meal repartition.
	 */
	private void createContent() {
		// Set properties to the frame
		frame = new JFrame("Dietetics Energy needs calcultaion.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = frame.getContentPane();
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.PAGE_AXIS);
		container.setLayout(containerLayout);

		// Add carbohydrate percentage
		JPanel carboHydratePan = new JPanel();
		carboHydratePan.setLayout(new BoxLayout(carboHydratePan, BoxLayout.LINE_AXIS));
		carbohydratePercentageLabel = new JLabel("Carbohydrate percentage wished by meal :");
		carboHydratePan.add(carbohydratePercentageLabel);
		carboHydratePan.add(Box.createHorizontalGlue());
		carbohydratePercentageTextField = new JTextField(3);
		carbohydratePercentageTextField.setMaximumSize(new Dimension(10, 20));
		carbohydratePercentageTextField.setText("" + (int)(MealRepartition.CARBOHYDRATE_PERCENTAGE_MIN * 100));
		carbohydratePercentageTextField.addFocusListener(this);
		carboHydratePan.add(carbohydratePercentageTextField);
		container.add(carboHydratePan);

		carbohydratePercentageSlider = new JSlider(JSlider.HORIZONTAL, (int)(MealRepartition.CARBOHYDRATE_PERCENTAGE_MIN * 100), (int)(MealRepartition.CARBOHYDRATE_PERCENTAGE_MAX * 100), (int)(MealRepartition.CARBOHYDRATE_PERCENTAGE_MIN * 100));
		carbohydratePercentageSlider.setMajorTickSpacing(1);
		carbohydratePercentageSlider.setMinorTickSpacing(1);
		carbohydratePercentageSlider.setPaintTicks(true);
		carbohydratePercentageSlider.setPaintLabels(true);
		carbohydratePercentageSlider.addChangeListener(this);
		container.add(carbohydratePercentageSlider);
		container.add(Box.createVerticalGlue());

		// Add protein percentage
		JPanel proteinPercentagePan = new JPanel();
		proteinPercentagePan.setLayout(new BoxLayout(proteinPercentagePan, BoxLayout.LINE_AXIS));
		proteinPercentageLabel = new JLabel("Protein percentage wished by meal :");
		proteinPercentagePan.add(proteinPercentageLabel);
		proteinPercentagePan.add(Box.createHorizontalGlue());
		proteinPercentageTextField = new JTextField(3);
		proteinPercentageTextField.setMaximumSize(new Dimension(10, 20));
		proteinPercentageTextField.setText("" + (int)(MealRepartition.PROTEIN_PERCENTAGE_MAX * 100));
		proteinPercentageTextField.addFocusListener(this);
		proteinPercentagePan.add(proteinPercentageTextField);
		container.add(proteinPercentagePan);

		proteinPercentageSlider = new JSlider(JSlider.HORIZONTAL, (int)(MealRepartition.PROTEIN_PERCENTAGE_MIN * 100), (int)(MealRepartition.PROTEIN_PERCENTAGE_MAX * 100), (int)(MealRepartition.PROTEIN_PERCENTAGE_MAX * 100));
		proteinPercentageSlider.setMajorTickSpacing(1);
		proteinPercentageSlider.setMinorTickSpacing(1);
		proteinPercentageSlider.setPaintTicks(true);
		proteinPercentageSlider.setPaintLabels(true);
		proteinPercentageSlider.addChangeListener(this);
		container.add(proteinPercentageSlider);
		container.add(Box.createVerticalGlue());

		// Add lipid percentage
		JPanel lipidPercentagePan = new JPanel();
		lipidPercentagePan.setLayout(new BoxLayout(lipidPercentagePan, BoxLayout.LINE_AXIS));
		lipidPercentageLabel = new JLabel("Lipid percentage wished by meal :");
		lipidPercentagePan.add(lipidPercentageLabel);
		lipidPercentagePan.add(Box.createHorizontalGlue());
		lipidPercentageTextField = new JTextField(3);
		lipidPercentageTextField.setMaximumSize(new Dimension(10, 20));
		lipidPercentageTextField.setText("" + (int)(MealRepartition.LIPID_PERCENTAGE_MIN * 100));
		lipidPercentageTextField.addFocusListener(this);
		lipidPercentagePan.add(lipidPercentageTextField);
		container.add(lipidPercentagePan);

		lipidPercentageSlider = new JSlider(JSlider.HORIZONTAL, (int)(MealRepartition.LIPID_PERCENTAGE_MIN * 100), (int)(MealRepartition.LIPID_PERCENTAGE_MAX * 100), (int)(MealRepartition.LIPID_PERCENTAGE_MIN * 100));
		lipidPercentageSlider.setMajorTickSpacing(1);
		lipidPercentageSlider.setMinorTickSpacing(1);
		lipidPercentageSlider.setPaintTicks(true);
		lipidPercentageSlider.setPaintLabels(true);
		lipidPercentageSlider.addChangeListener(this);
		container.add(lipidPercentageSlider);
		container.add(Box.createVerticalGlue());

		// Add take a snack checkbox
		JPanel snackPan = new JPanel();
		snackPan.setLayout(new BoxLayout(snackPan, BoxLayout.LINE_AXIS));
		takeASnackLabel = new JLabel("The patient take a snack");
		snackPan.add(takeASnackLabel);
		takeASnackCheckBox = new JCheckBox();
		snackPan.add(takeASnackCheckBox);
		snackPan.add(Box.createHorizontalGlue());
		container.add(snackPan);

		// Add the Ok button to the frame
		okBtn = new JButton("Ok");
		okBtn.addActionListener(this);
		container.add(okBtn);

		frame.setSize(new Dimension(450, 400));
		frame.setLocationRelativeTo(null);
	}


	/**
	 * Get the user data and return the corresponding MealRepartition object.
	 * @return The MealRepartition object corresponding to the user data.
	 * @throws BadCarbohydratePercentageException
	 * @throws BadLipidPercentageException
	 * @throws BadProteinPercentageException
	 */
	private MealRepartition getUserData() throws BadCarbohydratePercentageException, BadLipidPercentageException, BadProteinPercentageException {
		MealRepartition mr = new MealRepartition();
		mr.setCarbohydratePercentage(carbohydratePercentageSlider.getValue() / 100.);
		mr.setLipidPercentage(lipidPercentageSlider.getValue() / 100.);
		mr.setProteinPercentage(proteinPercentageSlider.getValue() / 100.);
		mr.setTakeASnack(takeASnackCheckBox.isSelected());

		return mr;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			MealRepartition mr = getUserData();
			if(mr != null) {
				controller.notifyMealRepartitionChanged(mr);
			}
		} catch(Exception exc) {
			JOptionPane.showMessageDialog(frame, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	/**
	 * Display the view of meal repartition.
	 */
	public void display() {
		frame.setVisible(true);
	}


	/**
	 * Close the view and free all its elements.
	 */
	public void close() {
		frame.dispose();
	}


	@Override
	public void stateChanged(ChangeEvent event) {
		if(event.getSource() == carbohydratePercentageSlider) {
			try {
				carbohydratePercentageTextField.setText(String.valueOf(carbohydratePercentageSlider.getValue()));
			} catch(NumberFormatException nfe) {}
		} else if(event.getSource() == proteinPercentageSlider) {
			try {
				proteinPercentageTextField.setText(String.valueOf(proteinPercentageSlider.getValue()));
			} catch(NumberFormatException nfe) {}
		} else if(event.getSource() == lipidPercentageSlider) {
			try {
				lipidPercentageTextField.setText(String.valueOf(lipidPercentageSlider.getValue()));
			} catch(NumberFormatException nfe) {}
		}
	}


	@Override
	public void focusGained(FocusEvent arg0) {}


	@Override
	public void focusLost(FocusEvent event) {
		if(event.getSource() == carbohydratePercentageTextField) {
			try {
				carbohydratePercentageSlider.setValue(Integer.valueOf(carbohydratePercentageTextField.getText()));
			} catch(NumberFormatException nfe) {
				carbohydratePercentageTextField.setText(String.valueOf(carbohydratePercentageSlider.getValue()));
			}
		} else if(event.getSource() == lipidPercentageTextField) {
			try {
				lipidPercentageSlider.setValue(Integer.valueOf(lipidPercentageTextField.getText()));
			} catch(NumberFormatException nfe) {
				lipidPercentageTextField.setText(String.valueOf(lipidPercentageSlider.getValue()));
			}
		} else if(event.getSource() == proteinPercentageTextField) {
			try {
				proteinPercentageSlider.setValue(Integer.valueOf(proteinPercentageTextField.getText()));
			} catch(NumberFormatException nfe) {
				proteinPercentageTextField.setText(String.valueOf(proteinPercentageSlider.getValue()));
			}
		}
	}

}
