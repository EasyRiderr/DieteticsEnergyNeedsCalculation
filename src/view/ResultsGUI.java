/*
 * ResultsGUI.java
 * 
 * The GUI representing the Results.
 * 16/03/2014 
 */


package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

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
	private JPanel breakfastPanel;
	private JPanel lunchPanel;
	private JPanel dinnerPanel;
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


	public ResultsGUI() {
		// Set properties to the frame
		frame = new JFrame("Dietetics Energy needs calculation.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));
		
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
		
		breakfastPanel = new JPanel();
		breakfastPanel.setLayout(new BoxLayout(breakfastPanel, BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(breakfastPanel);
		int i = 0 ;
		for( ; i < 6 ; ++i) {
			breakfastPanel.add(labels[i]);
			breakfastPanel.add(value_labels[i]);
		}
		
		lunchPanel = new JPanel();
		lunchPanel.setLayout(new BoxLayout(lunchPanel, BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(lunchPanel);
		for( ; i < 12 ; ++i) {
			lunchPanel.add(labels[i]);
			lunchPanel.add(value_labels[i]);
		}
		
		dinnerPanel = new JPanel();
		dinnerPanel.setLayout(new BoxLayout(dinnerPanel, BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(dinnerPanel);
		for( ; i < 18 ; ++i) {
			dinnerPanel.add(labels[i]);
			dinnerPanel.add(value_labels[i]);
		}
		
		snackPanel = new JPanel();
		snackPanel.setLayout(new BoxLayout(snackPanel, BoxLayout.PAGE_AXIS));
		//frame.getContentPane().add(snackPanel);
		for( ; i < 24 ; ++i) {
			snackPanel.add(labels[i]);
			snackPanel.add(value_labels[i]);
		}
		
		btnPanel = new JPanel();
		frame.getContentPane().add(btnPanel);
		okBtn = new JButton("Quit");
		okBtn.addActionListener(this);
		btnPanel.add(label_s_p);
		btnPanel.add(value_labels[24]);
		btnPanel.add(okBtn);
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
			frame.getContentPane().add(snackPanel);
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
			frame.getContentPane().remove(snackPanel);
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
