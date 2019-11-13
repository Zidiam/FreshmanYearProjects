/*
 * GCDandBlurbPanel.java -- Is the backbone of the GUI in which tells us how the buttons and elements of the GUI interact with the user
 * Jason Melnik
 * 9/12/2019
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GCDandBlurbPanel extends JPanel{
	
	private final int WIDTH = 500, HEIGHT = 500;
	private int speed = 75;
	private JTextField GCD1, GCD2, Blurb;
	private JLabel LGCD1, LGCD2, LBlurb, GCDC, EBlurb, LError, AGCD, Creator;
	private JButton Genter, Benter;
	private GCDandBlurbPanel ths;
	
	public GCDandBlurbPanel() {
		ths = this;
		
		setupInteract();
		setupNonInteract();
		
		setLayout(null);
		
		setBackground(Color.yellow);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		
	}
	
	public void setupInteract() {
		Benter = new JButton("Enter");
		Genter = new JButton("Enter");
		GCD1 = new JTextField();
		GCD2 = new JTextField();
		Blurb = new JTextField();
		
		Benter.setBounds(25, 275, 75, 25);
		Genter.setBounds(125, 100, 75, 25);
		GCD1.setBounds(75, 50, 75, 25);
		GCD2.setBounds(250, 50, 75, 25);
		Blurb.setBounds(75, 225, 75, 25);
		
		Benter.addActionListener(new ButtonListener());
		Genter.addActionListener(new ButtonListener());
		
		add(Benter);
		add(Genter);
		add(GCD1);
		add(GCD2);
		add(Blurb);
		
	}
			
	public void setupNonInteract() {
		LGCD1 = new JLabel("Number 1:");
		LGCD2 = new JLabel("Number 2:");
		LBlurb = new JLabel("Blurb Word Maker");
		GCDC = new JLabel("Greatest Common Divisor Calculator");
		LError = new JLabel("");
		EBlurb = new JLabel("Amount:");
		AGCD = new JLabel("Answer: ");
		Creator = new JLabel("Made by Jason Melnik");
		
		LGCD1.setBounds(0, 50, 75, 25);
		LGCD2.setBounds(175, 50, 75, 25);
		LBlurb.setBounds(200, 175, 300, 25);
		GCDC.setBounds(150, 0, 300, 25);
		LError.setBounds(0, 150, 500, 25);
		EBlurb.setBounds(0, 225, 75, 25);
		AGCD.setBounds(350, 50, 75, 25);
		Creator.setBounds(375, 125, 125, 25);
		
		Creator.setForeground(Color.CYAN);
		LError.setForeground(Color.RED);
		
		add(LGCD1);
		add(LGCD2);
		add(LBlurb);
		add(GCDC);
		add(LError);
		add(EBlurb);
		add(AGCD);
		add(Creator);
	}
	
	public void makeBlurbs(int ammount) {
		Blurb blurb = new Blurb();
		ArrayList<JLabel> tempList = new ArrayList<JLabel>();
		int z = 0;
		int w = 0;
		for(int x = 0; x < ammount; x++) {
			JLabel temp = new JLabel(blurb.getBlurb());
			temp.setBounds(z, 300 + w * 25, 250, 25);
			tempList.add(temp);
			w ++;
			if(w > 7) {
				z = 270;
				w = 0;
			}
		}
		
		for(JLabel label : tempList) {
			ths.add(label);
		}
		
		ths.update(ths.getGraphics());
		
		for(JLabel label : tempList) {
			ths.remove(label);
		}
		
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.setColor(Color.GREEN);
		page.drawLine(0, 150, 600, 150);
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == Genter) {
				try {
				AGCD.setText("Answer: " + GreatestCommonDiviser.gcd(Integer.parseInt(GCD1.getText()), Integer.parseInt(GCD2.getText())));
				LError.setText("");
				}
				catch(Exception e){
					if(GCD1.getText().equals("") || GCD2.getText().equals("")) {
						LError.setText("Please fill in all inputs");
					}
					else
						LError.setText("Please enter integers for the inputs");
				}
			}
			if(event.getSource() == Benter) {
				try {
					if(Integer.parseInt(Blurb.getText()) > 16) {
						LError.setText("Please enter an input that is less than 16 for Blurb Word Maker");
					}
					else {
						makeBlurbs(Integer.parseInt(Blurb.getText()));
						LError.setText("");
					}
				}
				catch(Exception e){
					if(Blurb.getText().equals("")) {
						LError.setText("Please fill in all inputs");
					}
					else
						LError.setText("Please enter integers for the inputs");
				}
			}
		}
	}
}
	
	

