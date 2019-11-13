import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
 * 
 */
public class DogPanel extends JPanel{
	
	private static JComboBox<String> allDogs;
	private JLabel age, color, name, details, ageL, colorL, nameL, detailsL;
	private static ArrayList<Dog> dogs;
	
	public DogPanel() {
		allDogs = new JComboBox<String>();
		dogs = new ArrayList<Dog>();
		
		allDogs.addActionListener(new ButtonListener());
		
		Dog dog1 = new Dog(5, "Black", "Bob", "Fat");
		dogs.add(dog1);
		dog1 = new Dog(5, "Black", "Bob", "Fat");
		dogs.add(dog1);
		
		allDogs.addItem("     ");
		allDogs.addItem(dog1.getName());
		
		age = new JLabel();
		color = new JLabel();
		name = new JLabel();
		details = new JLabel();
		
		ageL = new JLabel("Age:");
		colorL = new JLabel("Color:");
		nameL = new JLabel("Name:");
		detailsL = new JLabel("Details:");
		
		add(allDogs);
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
			for(int x = 0; x < dogs.size(); x++) {
				if(allDogs.getSelectedIndex() == x && x != 0) {
					dogUpdate(dogs.get(x));
					
				}
			}
		}
	}
	
	private void dogUpdate(Dog Dogs) {
		age.setText(Dogs.getAge() + "");
		name.setText(Dogs.getName());
		color.setText(Dogs.getColor());
		details.setText(Dogs.getDetails());
	}
	
	public static void addDog(Dog CC) {
		allDogs.addItem(CC.getName());
		dogs.add(CC);
	}
}

