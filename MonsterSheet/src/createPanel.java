/*
 * CabalPanel.java -- This is a JPanel that has button elements that help show and change stats of all Cabal Creatures!
 * Jason Melnik
 * 2/8/2019
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class createPanel extends JPanel{
	
	private JButton createButton;
	private JLabel picture;
	private JTextField name, noise, weight, speed, skills, weapon, url;
	private JLabel nameL, noiseL, weightL, speedL, skillsL, weaponL, urlL;
	private MonsterPanel env;
	private JComboBox<String> species;
	private JTextField[] textList;
	private JLabel[] labelList;
	
	public createPanel(){
		
		
		species = new JComboBox<String>();
		species.addItem("Select Species");
		species.addItem("Hive");
		species.addItem("Fallen");
		species.addItem("Cabal");
		species.addItem("Vex");
		
		setBackground(Color.BLACK);
    	
    	ButtonListener listener = new ButtonListener();
    	species.addActionListener(listener);
    	species.setBounds(200, 10, species.getPreferredSize().width, species.getPreferredSize().height);
    	
    	setLayout(null);
    	
    	name = new JTextField("");
    	noise = new JTextField("");
    	weight = new JTextField("");
    	speed = new JTextField("");
    	skills = new JTextField("");
    	weapon = new JTextField("");
    	url = new JTextField("");
    	
    	nameL = new JLabel("Name:");
    	noiseL = new JLabel("Noise:");
    	weightL = new JLabel("Weight:");
    	speedL = new JLabel("Speed:");
    	skillsL = new JLabel("Skills:");
    	weaponL = new JLabel("Weapon:");
    	urlL = new JLabel("Image:");
    	
    	textList = new JTextField[]{name, noise, weight, speed, skills, weapon, url};
    	labelList = new JLabel[]{nameL, noiseL, weightL, speedL, skillsL, weaponL, urlL};
    	
    	for(int x = 2; x < textList.length+2; x ++) {
    		labelList[x-2].setForeground(Color.BLUE);
    		labelList[x-2].setBounds(10, x*30, 60, 20);
    		textList[x-2].setBounds(65, x*30, 415, 20);
    		textList[x-2].addKeyListener(new KeysListener());
    		add(textList[x-2]);
    		add(labelList[x-2]);
    	}
    	
    	
    	createButton = new JButton("Create");
    	createButton.setBackground(Color.CYAN);
    	createButton.setForeground(Color.BLACK);
    	createButton.addActionListener(new ButtonListener());
    	createButton.setBounds(220, 270, createButton.getPreferredSize().width, createButton.getPreferredSize().height);
    	
    	add(createButton);
		add(species);
    	
    	picture = new JLabel(new ImageIcon());
    	picture.setBounds(180, 100, 150, 150);
    	
    	add(picture);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(createButton == event.getSource()) {
				MonsterSheetPanel.tabbedPane.setSelectedIndex(species.getSelectedIndex());
				
				if(species.getSelectedIndex() == 1) {
					HiveCreature monster = new HiveCreature(name.getText());
					monster.setType(name.getText());
					monster.setNoise(noise.getText());
					monster.setSkills(skills.getText());
					monster.setSpeed(speed.getText());
					monster.setWeapon(weapon.getText());
					monster.setWeight(weight.getText());
					HivePanel.addCreature(monster);
				}
				if(species.getSelectedIndex() == 2) {
					FallenCreature monster = new FallenCreature(name.getText());
					monster.setType(name.getText());
					monster.setNoise(noise.getText());
					monster.setSkills(skills.getText());
					monster.setSpeed(speed.getText());
					monster.setWeapon(weapon.getText());
					monster.setWeight(weight.getText());
					monster.setImage(urlL.getText());
					FallenPanel.addCreature(monster);
				}
				if(species.getSelectedIndex() == 3) {
					CabalCreature monster = new CabalCreature(name.getText());
					monster.setType(name.getText());
					monster.setNoise(noise.getText());
					monster.setSkills(skills.getText());
					monster.setSpeed(speed.getText());
					monster.setWeapon(weapon.getText());
					monster.setWeight(weight.getText());
					CabalPanel.addCreature(monster);
				}
				if(species.getSelectedIndex() == 4) {
					VexCreature monster = new VexCreature(name.getText());
					monster.setType(name.getText());
					monster.setNoise(noise.getText());
					monster.setSkills(skills.getText());
					monster.setSpeed(speed.getText());
					monster.setWeapon(weapon.getText());
					monster.setWeight(weight.getText());
					VexPanel.addCreature(monster);
				}
				
				for(int x = 0; x < textList.length; x++) {
					textList[x].setText("");
				}
			}
		}
    }
	
	private class KeysListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			//might need it later
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	
}
