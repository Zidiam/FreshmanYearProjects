import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class LayoutManager extends JPanel{
	
	AddPanel addPanel = new AddPanel();
	public JTabbedPane speciesTab;
	
	
	
	public LayoutManager() {
		speciesTab = new JTabbedPane();
		speciesTab.setLayout(new GridLayout(1, 1));
		
		setupDogTab();
		setupAddTab();
		
		add(speciesTab);
		super.setBackground(Color.blue);
		speciesTab.setBackground(Color.WHITE);
		speciesTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
	private void setupAddTab() {
		AddPanel addPanel = new AddPanel();
		
		speciesTab.addTab("Create", addPanel);
	}
	
	private void setupDogTab() {
		DogPanel dPanel = new DogPanel();
		
		dPanel.setPreferredSize(new Dimension(400, 300));
		speciesTab.addTab("Dog", dPanel);
		
	}
}