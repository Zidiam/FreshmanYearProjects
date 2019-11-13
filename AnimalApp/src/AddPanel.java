import java.awt.Component;

import javax.swing.*;

public class AddPanel extends JPanel{
	private String FieldPanel;
	
	
	public AddPanel() {
		add(getFieldPanel());
		add(getButtonPanel());
	}
	
	   private void setFieldPanel(String FieldPanel) {
		   this.FieldPanel = FieldPanel;
	   }
	   
	   
	   static JPanel getFieldPanel() {
	      JPanel p = new JPanel();
	      p.setSize(600, 50);
	      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
	      p.setBorder(BorderFactory.createTitledBorder("Details"));
	      p.add(getValuePanel());
	      return p;
	     
	   }  
	   static JPanel getButtonPanel() {
	      JPanel p = new JPanel();
	      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
	      p.add(new JButton("OK"));
	      p.add(new JButton("Cancel"));
	      return p;
	   }

	   private static JPanel getValuePanel() {
	      JPanel p = new JPanel();
	      p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	      JComponent c = new JTextField(16);
	      c.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(c);
	      JPanel s = getSystemPanel();
	      s.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(s);
	      s = getLanguagePanel();
	      s.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(s);
	      JLabel a = new JLabel();
	      a = new JLabel("Age:");
	      p.add(a);
	      JComboBox<String> b = new JComboBox<String>(
	         new String[] {"1","2","3","4","5","6","7","8","9","10 or above"});
	      
	      b.setAlignmentX(Component.LEFT_ALIGNMENT);
	      p.add(b);
	      return p;
	      
	   }
	   private static JPanel getSystemPanel() {
	      JRadioButton dButton = new JRadioButton("Dog",true);
	      JRadioButton cButton = new JRadioButton("Cat",false);
	      JRadioButton pButton = new JRadioButton("Parrot",false);
	      JRadioButton fButton = new JRadioButton("Fish",false);
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
	   private static JPanel getLanguagePanel() {
	      JPanel p = new JPanel();
	      JLabel a = new JLabel();
	      a = new JLabel("Color:");
	      p.add(a);
	      p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
	      p.add(new JCheckBox("Black",false));
	      p.add(new JCheckBox("White",false));
	      p.add(new JCheckBox("Orange",false));
	      p.add(new JCheckBox("Grey",false));
	      p.add(new JCheckBox("Other",false));
	      return p;
	          
	   }
}
