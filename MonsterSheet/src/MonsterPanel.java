import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * 
 */
public class MonsterPanel extends JPanel{
	private JButton hiveButton, fallenButton, cabalButton, vexButton;
	private JButton[] mainMonsterButtons;
	
	MonsterPanel(){
		setBackground(Color.BLACK);
		
		hiveButton = new JButton("The Hive");
    	fallenButton = new JButton("The Fallen");
    	cabalButton = new JButton("The Cabal");
    	vexButton = new JButton("The Vex");
    	
    	mainMonsterButtons = new JButton[4];
    	
    	mainMonsterButtons[0] = hiveButton;
    	mainMonsterButtons[1] = fallenButton;
    	mainMonsterButtons[2] = cabalButton;
    	mainMonsterButtons[3] = vexButton;
    	
    	ButtonListener listener = new ButtonListener();
    	
    	for(JButton button : mainMonsterButtons){
    		button.setBorderPainted(false);
        	button.setBackground(getBackground());
        	button.setForeground(Color.RED);
        	button.setFocusable(false);
        	button.addActionListener(listener);
        	add(button);
    	}
    	
    	setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == hiveButton) {
				MonsterSheetPanel.tabbedPane.setSelectedIndex(1);
			}
			if(event.getSource() == fallenButton) {
				MonsterSheetPanel.tabbedPane.setSelectedIndex(2);
			}
			if(event.getSource() == cabalButton) {
				MonsterSheetPanel.tabbedPane.setSelectedIndex(3);
			}
			if(event.getSource() == vexButton) {
				MonsterSheetPanel.tabbedPane.setSelectedIndex(4);
			}
		}
    }
	
}
