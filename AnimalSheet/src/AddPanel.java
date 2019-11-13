import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddPanel extends JPanel{
	private String FieldPanel;
	private JButton okButton;
	private JButton cancleButton;
	private JComboBox<String> b;
	JTextField c, n;
	JCheckBox Cblack, Cwhite, Corage, Cgrey, Cother, Corange;
	JRadioButton dButton, cButton, pButton, fButton;
	
	public AddPanel() {
		okButton = new JButton("OK");
		cancleButton = new JButton("Cancle");
		add(getFieldPanel());
		
		okButton.addActionListener(new ButtonListener());
		cancleButton.addActionListener(new ButtonListener());
		add(okButton);
		add(cancleButton);
	}
	   
	   private JPanel getFieldPanel() {
	      JPanel p = new JPanel();
	      p.setSize(600, 50);
	      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
	      p.setBorder(BorderFactory.createTitledBorder("Details"));
	      p.add(getValuePanel());
	      return p;
	     
	   }  

	   private JPanel getValuePanel() {
	      JPanel p = new JPanel();
	      p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	      c = new JTextField(16);
	      c.addActionListener(new ButtonListener());
	      c.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(c);
	      JLabel name = new JLabel("Name:");
	      name.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(name);
	      n = new JTextField(16);
	      n.addActionListener(new ButtonListener());
	      n.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(n);
	      JPanel s = getSystemPanel();
	      s.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(s);
	      s = getLanguagePanel();
	      s.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(s);
	      JLabel a = new JLabel();
	      a = new JLabel("Age:");
	      p.add(a);
	      b = new JComboBox<String>(
	         new String[] {"1","2","3","4","5","6","7","8","9","10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"});
	      
	      b.addActionListener(new ButtonListener());
	      b.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(b);
	      return p;
	      
	   }
	   private JPanel getSystemPanel() {
	      dButton = new JRadioButton("Dog",true);
	      cButton = new JRadioButton("Cat",false);
	      pButton = new JRadioButton("Parrot",false);
	      fButton = new JRadioButton("Fish",false);
	      dButton.addActionListener(new ButtonListener());
	      cButton.addActionListener(new ButtonListener());
	      pButton.addActionListener(new ButtonListener());
	      fButton.addActionListener(new ButtonListener());
	      ButtonGroup systemGroup = new ButtonGroup();
	      JPanel p = new JPanel();
	      JLabel a = new JLabel();
	      a = new JLabel("Animal:");
	      p.add(a);
	      systemGroup.add(dButton);
	      systemGroup.add(cButton);
	      systemGroup.add(pButton);
	      systemGroup.add(fButton);
	      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
	      p.add(dButton);
	      p.add(cButton);
	      p.add(pButton);
	      p.add(fButton);
	      return p;
	      
	   }
	   private JPanel getLanguagePanel() {
	      JPanel p = new JPanel();
	      JLabel a = new JLabel();
	      a = new JLabel("Color:");
	      p.add(a);
	      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
	      Cblack = new JCheckBox("Black",false);
	      Cwhite = new JCheckBox("White",false);
	      Corange = new JCheckBox("Orange",false);
	      Cgrey = new JCheckBox("Grey",false);
	      Cother = new JCheckBox("Other",false);
	      Cblack.addActionListener(new ButtonListener());
	      Cwhite.addActionListener(new ButtonListener());
	      Corange.addActionListener(new ButtonListener());
	      Cgrey.addActionListener(new ButtonListener());
	      Cother.addActionListener(new ButtonListener());
	      p.add(Cblack);
	      p.add(Cwhite);
	      p.add(Corange);
	      p.add(Cgrey);
	      p.add(Cother);
	      return p;
	          
	   }
	   
	   private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == okButton) {
				String strng = "";
				if(Cblack.isSelected()) {
					strng = "black ";
				}
				if(Cwhite.isSelected()) {
					strng = strng + " white ";
				}
				if(Corange.isSelected()) {
					strng = strng + " orange ";
				}
				if(Cgrey.isSelected()) {
					strng = strng + " grey ";
				}
				if(Cother.isSelected()) {
					strng = strng + " other ";
				}
				
				if(dButton.isSelected()) {
					Dog temp = new Dog(Integer.parseInt(b.getSelectedItem().toString()), strng, n.getText(), c.getText());
					DogPanel.addDog(temp);
				}
				if(cButton.isSelected()) {
					Cat temp = new Cat(Integer.parseInt(b.getSelectedItem().toString()), strng, n.getText(), c.getText());
					CatPanel.addCat(temp);
				}
				if(pButton.isSelected()) {
					Parrot temp = new Parrot(Integer.parseInt(b.getSelectedItem().toString()), strng, n.getText(), c.getText());
					ParrotPanel.addParrot(temp);
				}
				if(fButton.isSelected()) {
					Fish temp = new Fish(Integer.parseInt(b.getSelectedItem().toString()), strng, n.getText(), c.getText());
					FishPanel.addFish(temp);
				}
			}
			if(e.getSource() == cancleButton) {
				Cblack.setSelected(false);
			    Cwhite.setSelected(false);
			    Corange.setSelected(false);
			    Cgrey.setSelected(false);
			    Cother.setSelected(false);
			    
			    dButton.setSelected(true);
			    cButton.setSelected(false);
			    pButton.setSelected(false);
			    fButton.setSelected(false);
			    
			    c.setText("");
			    n.setText("");
			    
			    b.setSelectedIndex(0);
			}
			
		}
	   }
}
