
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MonsterSheetPanel extends JPanel {
	private JComponent panel1, panel2, panel3, panel4, panel5, panel6;
	public static JTabbedPane tabbedPane = new JTabbedPane();
	private ImageIcon icon;
	
    public MonsterSheetPanel() {
        tabbedPane.setLayout(new GridLayout(1, 1));
        icon = new ImageIcon();
         
        setupTabPanel1();
        setupTabPanel2();
        setupTabPanel3();
        setupTabPanel4();
        setupTabPanel5();
        setupTabPanel6();
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        super.setBackground(Color.BLUE);
        tabbedPane.setBackground(Color.CYAN);
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    public void setupTabPanel1() {
    	panel1 = new MonsterPanel();
  
        tabbedPane.addTab("Monsters", icon, panel1, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    }
    
    public void setupTabPanel2() {
    	panel2 = new HivePanel();
        tabbedPane.addTab("Hive", icon, panel2, "Still does nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    }
    
    public void setupTabPanel3() {
    	panel3 = new FallenPanel();
        tabbedPane.addTab("Fallen", icon, panel3, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    }
    
    public void setupTabPanel4() {
    	panel4 = new CabalPanel();
        tabbedPane.addTab("Cabal", icon, panel4, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
    }
    
    public void setupTabPanel5() {
    	panel5 = new VexPanel();
        tabbedPane.addTab("Vex", icon, panel5, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
    }
    
    public void setupTabPanel6() {
    	panel6 = new createPanel();
        panel6.setPreferredSize(new Dimension(750, 500));
        tabbedPane.addTab("Create", icon, panel6, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_5);
    }
     
}