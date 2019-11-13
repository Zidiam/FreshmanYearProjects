import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
 * 
 */
public class CatPanel extends JPanel{
	
	private static JComboBox<String> allCats;
	private JLabel age, color, name, details, ageL, colorL, nameL, detailsL;
	private static ArrayList<Cat> cats;
	
	public CatPanel() {
		allCats = new JComboBox<String>();
		cats = new ArrayList<Cat>();
		
		allCats.addActionListener(new ButtonListener());
		
		Cat cat1 = new Cat(5, "Black", "Bob", "Fat");
		cats.add(cat1);
		cat1 = new Cat(5, "Black", "Bob", "Fat");
		cats.add(cat1);
		
		allCats.addItem("     ");
		allCats.addItem(cat1.getName());
		
		age = new JLabel();
		color = new JLabel();
		name = new JLabel();
		details = new JLabel();
		
		ageL = new JLabel("Age:");
		colorL = new JLabel("Color:");
		nameL = new JLabel("Name:");
		detailsL = new JLabel("Details:");
		
		add(allCats);
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
			for(int x = 0; x < cats.size(); x++) {
				if(allCats.getSelectedIndex() == x && x != 0) {
					catUpdate(cats.get(x));
					
				}
			}
		}
	}
	
	private void catUpdate(Cat Cats) {
		age.setText(Cats.getAge() + "");
		name.setText(Cats.getName());
		color.setText(Cats.getColor());
		details.setText(Cats.getDetails());
	}
	
	public static void addCat(Cat CC) {
		allCats.addItem(CC.getName());
		cats.add(CC);
	}
}

