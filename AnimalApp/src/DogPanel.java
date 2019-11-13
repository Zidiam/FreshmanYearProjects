import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
 * 
 */
public class DogPanel extends JPanel{
	
	private JComboBox<String> allDogs;
	private JTextField age, color, name, details;
	private ArrayList<Dog> dogs;
	
	public DogPanel() {
		allDogs = new JComboBox<String>();
		dogs = new ArrayList<Dog>();
		
		allDogs.addActionListener(new ButtonListener());
		
		Dog dog1 = new Dog(5, "Black", "Bob", "Fat");
		dogs.add(dog1);
		
		allDogs.addItem(dog1.getName());
		
		age = new JTextField("");
		color = new JTextField("");
		name = new JTextField("");
		details = new JTextField("");
		
		add(allDogs);
		add(age);
		add(color);
		add(name);
		add(details);
		
		setBackground(Color.black);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			for(int x = 0; x < dogs.size(); x++) {
				if(allDogs.getSelectedIndex() == x) {
					dogUpdate(dogs.get(x));
				}
			}
		}
	}
	
	private void dogUpdate(Dog DD) {
		System.out.println(age);
		age = new JTextField(DD.getAge() + "");
	}
	
	private void addDog(Dog DD) {
		allDogs.addItem(DD.getName());
	}
}
