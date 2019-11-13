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
		
		setupAddTab();
		setupDogTab();
		setupCatTab();
		setupFishTab();
		setupParrotTab();
		
		
		
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
		speciesTab.addTab("Dog", dPanel);
		
	}
	private void setupParrotTab() {
		ParrotPanel pPanel = new ParrotPanel();
		speciesTab.addTab("Parrot", pPanel);
	}
	private void setupCatTab() {
		CatPanel cPanel = new CatPanel();
		speciesTab.addTab("Cat", cPanel);
	}
	private void setupFishTab() {
		FishPanel fPanel = new FishPanel();
		fPanel.setPreferredSize(new Dimension(400, 300));
		speciesTab.addTab("Fish", fPanel);
	}
}