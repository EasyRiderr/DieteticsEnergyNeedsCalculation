/*
 * ResultsGUI.java
 *
 * The GUI representing the Results.
 * 16/03/2014
 */


package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.mealRepartition.Meal;
import model.mealRepartition.MealRepartition;


/**
 * The GUI representing the results.
 *
 * @author Yoan DUMAS
 * @version 1.0
 */
public class ResultsGUI implements Observer, ActionListener {

	/** The frame of the GUI. */
	private JFrame frame;

	/** The OK button. */
	private JPanel btnPanel;
	private JButton okBtn;

	/** Panels for each meal. */
	private JPanel snackPanel;

	/**
	 * Labels to display values for each panel.
	 * [0 - 5]   => breakfast labels.
	 * [6 - 11]  => lunch labels.
	 * [12 - 17] => dinner labels.
	 * [18 - 23] => snack labels.
	 * [24]      => sweetened products.
	 */
	private JLabel[] value_labels = new JLabel[25];

	/**
	 * 0 : animal proteins.
	 * 1 : vegetable proteins.
	 * 2 : animal lipids.
	 * 3 : vegetable lipids.
	 * 4 : complex carbohydrate.
	 * 5 : simple carbohydrate.
	 */
	private JLabel[] labels = new JLabel[24];


	/** Sweetened products. */
	private JLabel label_s_p;


	// Ok this code is ugly, but I hate GUI so ...
	public ResultsGUI() {
		// Set properties to the frame
		frame = new JFrame("Dietetics Energy needs calculation.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));
		frame.setPreferredSize(new Dimension(1200, 200));

		for(int i = 0 ; i < value_labels.length ; ++i) {
			value_labels[i] = new JLabel("");
		}

		for(int i = 0 ; i < labels.length ; i += 6) {
			labels[i] = new JLabel("Animal proteins : ");
			labels[i + 1] = new JLabel("Vegetable proteins : ");
			labels[i + 2] = new JLabel("Animal lipids : ");
			labels[i + 3] = new JLabel("Vegetable lipids : ");
			labels[i + 4] = new JLabel("Complex carbohydrate : ");
			labels[i + 5] = new JLabel("Simple carbohydrate : ");
		}
		label_s_p = new JLabel("Sweetened products : ");

		JPanel breakfastPanel = new JPanel();
		breakfastPanel.setLayout(new BoxLayout(breakfastPanel, BoxLayout.PAGE_AXIS));

		JPanel panAnimalBreakfastProt = new JPanel();
		panAnimalBreakfastProt.setLayout(new BoxLayout(panAnimalBreakfastProt, BoxLayout.LINE_AXIS));
		panAnimalBreakfastProt.add(labels[0]);
		panAnimalBreakfastProt.add(Box.createHorizontalGlue());
		panAnimalBreakfastProt.add(value_labels[0]);
		breakfastPanel.add(panAnimalBreakfastProt);

		JPanel panVegetableBreakfastProt = new JPanel();
		panVegetableBreakfastProt.setLayout(new BoxLayout(panVegetableBreakfastProt, BoxLayout.LINE_AXIS));
		panVegetableBreakfastProt.add(labels[1]);
		panVegetableBreakfastProt.add(Box.createHorizontalGlue());
		panVegetableBreakfastProt.add(value_labels[1]);
		breakfastPanel.add(panVegetableBreakfastProt);

		JPanel panAnimalBreakfastLipid = new JPanel();
		panAnimalBreakfastLipid.setLayout(new BoxLayout(panAnimalBreakfastLipid, BoxLayout.LINE_AXIS));
		panAnimalBreakfastLipid.add(labels[2]);
		panAnimalBreakfastLipid.add(Box.createHorizontalGlue());
		panAnimalBreakfastLipid.add(value_labels[2]);
		breakfastPanel.add(panAnimalBreakfastLipid);

		JPanel panVegetableBreakfastLipid = new JPanel();
		panVegetableBreakfastLipid.setLayout(new BoxLayout(panVegetableBreakfastLipid, BoxLayout.LINE_AXIS));
		panVegetableBreakfastLipid.add(labels[3]);
		panVegetableBreakfastLipid.add(Box.createHorizontalGlue());
		panVegetableBreakfastLipid.add(value_labels[3]);
		breakfastPanel.add(panVegetableBreakfastLipid);

		JPanel panComplexBreakfastCarbo = new JPanel();
		panComplexBreakfastCarbo.setLayout(new BoxLayout(panComplexBreakfastCarbo, BoxLayout.LINE_AXIS));
		panComplexBreakfastCarbo.add(labels[4]);
		panComplexBreakfastCarbo.add(Box.createHorizontalGlue());
		panComplexBreakfastCarbo.add(value_labels[4]);
		breakfastPanel.add(panComplexBreakfastCarbo);

		JPanel panSimpleBreakfastCarbo = new JPanel();
		panSimpleBreakfastCarbo.setLayout(new BoxLayout(panSimpleBreakfastCarbo, BoxLayout.LINE_AXIS));
		panSimpleBreakfastCarbo.add(labels[5]);
		panSimpleBreakfastCarbo.add(Box.createHorizontalGlue());
		panSimpleBreakfastCarbo.add(value_labels[5]);
		breakfastPanel.add(panSimpleBreakfastCarbo);

		frame.getContentPane().add(breakfastPanel);
		frame.getContentPane().add(Box.createHorizontalGlue());

		JPanel lunchPanel = new JPanel();
		lunchPanel.setLayout(new BoxLayout(lunchPanel, BoxLayout.PAGE_AXIS));

		JPanel panAnimalLunchProt = new JPanel();
		panAnimalLunchProt.setLayout(new BoxLayout(panAnimalLunchProt, BoxLayout.LINE_AXIS));
		panAnimalLunchProt.add(labels[6]);
		panAnimalLunchProt.add(Box.createHorizontalGlue());
		panAnimalLunchProt.add(value_labels[6]);
		lunchPanel.add(panAnimalLunchProt);

		JPanel panVegetableLunchProt = new JPanel();
		panVegetableLunchProt.setLayout(new BoxLayout(panVegetableLunchProt, BoxLayout.LINE_AXIS));
		panVegetableLunchProt.add(labels[7]);
		panVegetableLunchProt.add(Box.createHorizontalGlue());
		panVegetableLunchProt.add(value_labels[7]);
		lunchPanel.add(panVegetableLunchProt);

		JPanel panAnimalLunchLipid = new JPanel();
		panAnimalLunchLipid.setLayout(new BoxLayout(panAnimalLunchLipid, BoxLayout.LINE_AXIS));
		panAnimalLunchLipid.add(labels[8]);
		panAnimalLunchLipid.add(Box.createHorizontalGlue());
		panAnimalLunchLipid.add(value_labels[8]);
		lunchPanel.add(panAnimalLunchLipid);

		JPanel panVegetableLunchLipid = new JPanel();
		panVegetableLunchLipid.setLayout(new BoxLayout(panVegetableLunchLipid, BoxLayout.LINE_AXIS));
		panVegetableLunchLipid.add(labels[9]);
		panVegetableLunchLipid.add(Box.createHorizontalGlue());
		panVegetableLunchLipid.add(value_labels[9]);
		lunchPanel.add(panVegetableLunchLipid);

		JPanel panComplexLunchCarbo = new JPanel();
		panComplexLunchCarbo.setLayout(new BoxLayout(panComplexLunchCarbo, BoxLayout.LINE_AXIS));
		panComplexLunchCarbo.add(labels[10]);
		panComplexLunchCarbo.add(Box.createHorizontalGlue());
		panComplexLunchCarbo.add(value_labels[10]);
		lunchPanel.add(panComplexLunchCarbo);

		JPanel panSimpleLunchCarbo = new JPanel();
		panSimpleLunchCarbo.setLayout(new BoxLayout(panSimpleLunchCarbo, BoxLayout.LINE_AXIS));
		panSimpleLunchCarbo.add(labels[11]);
		panSimpleLunchCarbo.add(Box.createHorizontalGlue());
		panSimpleLunchCarbo.add(value_labels[11]);
		lunchPanel.add(panSimpleLunchCarbo);

		frame.getContentPane().add(lunchPanel);
		frame.getContentPane().add(Box.createHorizontalGlue());

		snackPanel = new JPanel();
		snackPanel.setLayout(new BoxLayout(snackPanel, BoxLayout.PAGE_AXIS));

		JPanel panAnimalSnackProt = new JPanel();
		panAnimalSnackProt.setLayout(new BoxLayout(panAnimalSnackProt, BoxLayout.LINE_AXIS));
		panAnimalSnackProt.add(labels[12]);
		panAnimalSnackProt.add(Box.createHorizontalGlue());
		panAnimalSnackProt.add(value_labels[12]);
		snackPanel.add(panAnimalSnackProt);

		JPanel panVegetableSnackProt = new JPanel();
		panVegetableSnackProt.setLayout(new BoxLayout(panVegetableSnackProt, BoxLayout.LINE_AXIS));
		panVegetableSnackProt.add(labels[13]);
		panVegetableSnackProt.add(Box.createHorizontalGlue());
		panVegetableSnackProt.add(value_labels[13]);
		snackPanel.add(panVegetableSnackProt);

		JPanel panAnimalSnackLipid = new JPanel();
		panAnimalSnackLipid.setLayout(new BoxLayout(panAnimalSnackLipid, BoxLayout.LINE_AXIS));
		panAnimalSnackLipid.add(labels[14]);
		panAnimalSnackLipid.add(Box.createHorizontalGlue());
		panAnimalSnackLipid.add(value_labels[14]);
		snackPanel.add(panAnimalSnackLipid);

		JPanel panVegetableSnackLipid = new JPanel();
		panVegetableSnackLipid.setLayout(new BoxLayout(panVegetableSnackLipid, BoxLayout.LINE_AXIS));
		panVegetableSnackLipid.add(labels[15]);
		panVegetableSnackLipid.add(Box.createHorizontalGlue());
		panVegetableSnackLipid.add(value_labels[15]);
		snackPanel.add(panVegetableSnackLipid);

		JPanel panComplexSnackCarbo = new JPanel();
		panComplexSnackCarbo.setLayout(new BoxLayout(panComplexSnackCarbo, BoxLayout.LINE_AXIS));
		panComplexSnackCarbo.add(labels[16]);
		panComplexSnackCarbo.add(Box.createHorizontalGlue());
		panComplexSnackCarbo.add(value_labels[16]);
		snackPanel.add(panComplexSnackCarbo);

		JPanel panSimpleSnackCarbo = new JPanel();
		panSimpleSnackCarbo.setLayout(new BoxLayout(panSimpleSnackCarbo, BoxLayout.LINE_AXIS));
		panSimpleSnackCarbo.add(labels[17]);
		panSimpleSnackCarbo.add(Box.createHorizontalGlue());
		panSimpleSnackCarbo.add(value_labels[17]);
		snackPanel.add(panSimpleSnackCarbo);

		frame.getContentPane().add(snackPanel);
		frame.getContentPane().add(Box.createHorizontalGlue());

		JPanel dinnerPanel = new JPanel();
		dinnerPanel.setLayout(new BoxLayout(dinnerPanel, BoxLayout.PAGE_AXIS));

		JPanel panAnimalDinnerProt = new JPanel();
		panAnimalDinnerProt.setLayout(new BoxLayout(panAnimalDinnerProt, BoxLayout.LINE_AXIS));
		panAnimalDinnerProt.add(labels[18]);
		panAnimalDinnerProt.add(Box.createHorizontalGlue());
		panAnimalDinnerProt.add(value_labels[18]);
		dinnerPanel.add(panAnimalDinnerProt);

		JPanel panVegetableDinnerProt = new JPanel();
		panVegetableDinnerProt.setLayout(new BoxLayout(panVegetableDinnerProt, BoxLayout.LINE_AXIS));
		panVegetableDinnerProt.add(labels[19]);
		panVegetableDinnerProt.add(Box.createHorizontalGlue());
		panVegetableDinnerProt.add(value_labels[19]);
		dinnerPanel.add(panVegetableDinnerProt);

		JPanel panAnimalDinnerLipid = new JPanel();
		panAnimalDinnerLipid.setLayout(new BoxLayout(panAnimalDinnerLipid, BoxLayout.LINE_AXIS));
		panAnimalDinnerLipid.add(labels[20]);
		panAnimalDinnerLipid.add(Box.createHorizontalGlue());
		panAnimalDinnerLipid.add(value_labels[20]);
		dinnerPanel.add(panAnimalDinnerLipid);

		JPanel panVegetableDinnerLipid = new JPanel();
		panVegetableDinnerLipid.setLayout(new BoxLayout(panVegetableDinnerLipid, BoxLayout.LINE_AXIS));
		panVegetableDinnerLipid.add(labels[21]);
		panVegetableDinnerLipid.add(Box.createHorizontalGlue());
		panVegetableDinnerLipid.add(value_labels[21]);
		dinnerPanel.add(panVegetableDinnerLipid);

		JPanel panComplexDinnerCarbo = new JPanel();
		panComplexDinnerCarbo.setLayout(new BoxLayout(panComplexDinnerCarbo, BoxLayout.LINE_AXIS));
		panComplexDinnerCarbo.add(labels[22]);
		panComplexDinnerCarbo.add(Box.createHorizontalGlue());
		panComplexDinnerCarbo.add(value_labels[22]);
		dinnerPanel.add(panComplexDinnerCarbo);

		JPanel panSimpleDinnerCarbo = new JPanel();
		panSimpleDinnerCarbo.setLayout(new BoxLayout(panSimpleDinnerCarbo, BoxLayout.LINE_AXIS));
		panSimpleDinnerCarbo.add(labels[23]);
		panSimpleDinnerCarbo.add(Box.createHorizontalGlue());
		panSimpleDinnerCarbo.add(value_labels[23]);
		dinnerPanel.add(panSimpleDinnerCarbo);

		frame.getContentPane().add(dinnerPanel);
		frame.getContentPane().add(Box.createHorizontalGlue());


		btnPanel = new JPanel();
		okBtn = new JButton("Quit");
		okBtn.addActionListener(this);
		btnPanel.add(label_s_p);
		btnPanel.add(value_labels[24]);
		btnPanel.add(okBtn);
		frame.getContentPane().add(btnPanel);
		frame.pack();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okBtn) {
			System.exit(0);
		}
	}


	@Override
	public void update(Observable newMR, Object arg1) {
		if(arg1 != null) {
			display();
			return;
		}
		MealRepartition mr = (MealRepartition) newMR;
		value_labels[0].setText(Math.round(mr.getAnimalProteinsInGrams(Meal.Breakfast)) + "g");
		value_labels[1].setText(Math.round(mr.getVegetableProteinsInGrams(Meal.Breakfast)) + "g");
		value_labels[2].setText(Math.round(mr.getAnimalLipidInGrams(Meal.Breakfast)) + "g");
		value_labels[3].setText(Math.round(mr.getVegetableLipidInGrams(Meal.Breakfast)) + "g");
		value_labels[4].setText(Math.round(mr.getComplexCarbohydrate(Meal.Breakfast)) + "g");
		value_labels[5].setText(Math.round(mr.getSimpleCarbohydrate(Meal.Breakfast)) + "g");

		snackPanel.setVisible(mr.isTakeASnack());
		if(mr.isTakeASnack()) {
			value_labels[6].setText(Math.round(mr.getAnimalProteinsInGrams(Meal.Lunch)) + "g");
			value_labels[7].setText(Math.round(mr.getVegetableProteinsInGrams(Meal.Lunch)) + "g");
			value_labels[8].setText(Math.round(mr.getAnimalLipidInGrams(Meal.Lunch)) + "g");
			value_labels[9].setText(Math.round(mr.getVegetableLipidInGrams(Meal.Lunch)) + "g");
			value_labels[10].setText(Math.round(mr.getComplexCarbohydrate(Meal.Lunch)) + "g");
			value_labels[11].setText(Math.round(mr.getSimpleCarbohydrate(Meal.Lunch)) + "g");
			value_labels[12].setText(Math.round(mr.getAnimalProteinsInGrams(Meal.Dinner)) + "g");
			value_labels[13].setText(Math.round(mr.getVegetableProteinsInGrams(Meal.Dinner)) + "g");
			value_labels[14].setText(Math.round(mr.getAnimalLipidInGrams(Meal.Dinner)) + "g");
			value_labels[15].setText(Math.round(mr.getVegetableLipidInGrams(Meal.Dinner)) + "g");
			value_labels[16].setText(Math.round(mr.getComplexCarbohydrate(Meal.Dinner)) + "g");
			value_labels[17].setText(Math.round(mr.getSimpleCarbohydrate(Meal.Dinner)) + "g");
			value_labels[18].setText(Math.round(mr.getAnimalProteinsInGrams(Meal.Snack)) + "g");
			value_labels[19].setText(Math.round(mr.getVegetableProteinsInGrams(Meal.Snack)) + "g");
			value_labels[20].setText(Math.round(mr.getAnimalLipidInGrams(Meal.Snack)) + "g");
			value_labels[21].setText(Math.round(mr.getVegetableLipidInGrams(Meal.Snack)) + "g");
			value_labels[22].setText(Math.round(mr.getComplexCarbohydrate(Meal.Snack)) + "g");
			value_labels[23].setText(Math.round(mr.getSimpleCarbohydrate(Meal.Snack)) + "g");
		} else {
			value_labels[6].setText(Math.round(mr.getAnimalProteinsInGrams(Meal.LunchWithoutSnack)) + "g");
			value_labels[7].setText(Math.round(mr.getVegetableProteinsInGrams(Meal.LunchWithoutSnack)) + "g");
			value_labels[8].setText(Math.round(mr.getAnimalLipidInGrams(Meal.LunchWithoutSnack)) + "g");
			value_labels[9].setText(Math.round(mr.getVegetableLipidInGrams(Meal.LunchWithoutSnack)) + "g");
			value_labels[10].setText(Math.round(mr.getComplexCarbohydrate(Meal.LunchWithoutSnack)) + "g");
			value_labels[11].setText(Math.round(mr.getSimpleCarbohydrate(Meal.LunchWithoutSnack)) + "g");
			value_labels[12].setText(Math.round(mr.getAnimalProteinsInGrams(Meal.DinnerWithoutSnack)) + "g");
			value_labels[13].setText(Math.round(mr.getVegetableProteinsInGrams(Meal.DinnerWithoutSnack)) + "g");
			value_labels[14].setText(Math.round(mr.getAnimalLipidInGrams(Meal.DinnerWithoutSnack)) + "g");
			value_labels[15].setText(Math.round(mr.getVegetableLipidInGrams(Meal.DinnerWithoutSnack)) + "g");
			value_labels[16].setText(Math.round(mr.getComplexCarbohydrate(Meal.DinnerWithoutSnack)) + "g");
			value_labels[17].setText(Math.round(mr.getSimpleCarbohydrate(Meal.DinnerWithoutSnack)) + "g");
		}
		value_labels[24].setText(Math.round(mr.getSweetenedProductsinGrams()) + "g");

		frame.pack();
		frame.setLocationRelativeTo(null);
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

}
