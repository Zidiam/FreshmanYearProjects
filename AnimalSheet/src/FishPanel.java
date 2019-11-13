import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
 * 
 */
public class FishPanel extends JPanel{
	
	private static JComboBox<String> allFish;
	private JLabel age, color, name, details, ageL, colorL, nameL, detailsL;
	private static ArrayList<Fish> fishs;
	
	public FishPanel() {
		allFish = new JComboBox<String>();
		fishs = new ArrayList<Fish>();
		
		allFish.addActionListener(new ButtonListener());
		
		Fish fish1 = new Fish(5, "Black", "Bob", "Fat");
		fishs.add(fish1);
		fish1 = new Fish(5, "Black", "Bob", "Fat");
		fishs.add(fish1);
		
		allFish.addItem("     ");
		allFish.addItem(fish1.getName());
		
		age = new JLabel();
		color = new JLabel();
		name = new JLabel();
		details = new JLabel();
		
		ageL = new JLabel("Age:");
		colorL = new JLabel("Color:");
		nameL = new JLabel("Name:");
		detailsL = new JLabel("Details:");
		
		add(allFish);
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
			for(int x = 0; x < fishs.size(); x++) {
				if(allFish.getSelectedIndex() == x && x != 0) {
					fishUpdate(fishs.get(x));
					
				}
			}
		}
	}
	
	private void fishUpdate(Fish Fishs) {
		age.setText(Fishs.getAge() + "");
		name.setText(Fishs.getName());
		color.setText(Fishs.getColor());
		details.setText(Fishs.getDetails());
	}
	
	public static void addFish(Fish CC) {
		allFish.addItem(CC.getName());
		fishs.add(CC);
	}
}

