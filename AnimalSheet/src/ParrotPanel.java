import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
 * 
 */
public class ParrotPanel extends JPanel{
	
	private static JComboBox<String> allParrots;
	private JLabel age, color, name, details, ageL, colorL, nameL, detailsL;
	private static ArrayList<Parrot> Parrots;
	
	public ParrotPanel() {
		allParrots = new JComboBox<String>();
		Parrots = new ArrayList<Parrot>();
		
		allParrots.addActionListener(new ButtonListener());
		
		Parrot Parrot1 = new Parrot(5, "Black", "Bob", "Fat");
		Parrots.add(Parrot1);
		Parrot1 = new Parrot(5, "Black", "Bob", "Fat");
		Parrots.add(Parrot1);
		
		allParrots.addItem("     ");
		allParrots.addItem(Parrot1.getName());
		
		age = new JLabel();
		color = new JLabel();
		name = new JLabel();
		details = new JLabel();
		
		ageL = new JLabel("Age:");
		colorL = new JLabel("Color:");
		nameL = new JLabel("Name:");
		detailsL = new JLabel("Details:");
		
		add(allParrots);
		add(ageL);
		add(age);
		add(colorL);
		add(color);
		add(nameL);
		add(name);
		add(detailsL);
		add(details);
		
		setBackground(Color.white);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			for(int x = 0; x < Parrots.size(); x++) {
				if(allParrots.getSelectedIndex() == x && x != 0) {
					parrotUpdate(Parrots.get(x));
					
				}
			}
		}
	}
	
	private void parrotUpdate(Parrot Parrots) {
		age.setText(Parrots.getAge() + "");
		name.setText(Parrots.getName());
		color.setText(Parrots.getColor());
		details.setText(Parrots.getDetails());
	}
	
	public static void addParrot(Parrot CC) {
		allParrots.addItem(CC.getName());
		Parrots.add(CC);
	}
}

