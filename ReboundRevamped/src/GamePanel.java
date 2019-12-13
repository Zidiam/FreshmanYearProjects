/*
 * GamePanel.java -- Main game control panel for SuperGameApp
 * Jason Melnik
 * CSC 120
 * 11/27/18
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

public class GamePanel extends JPanel{
	private JLabel scoreBox;
	private JButton pushMe;
	private GraphicsPanel gPanel;
	
	public GamePanel() {

		gPanel = new GraphicsPanel(this);
		
		scoreBox = new JLabel("Score: " + gPanel.getScore());
		
		setPreferredSize(new Dimension(gPanel.WIDTH + 20, gPanel.HEIGHT + 50));
		setBackground(Color.ORANGE);
		
		add(scoreBox);
		add(gPanel);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		scoreBox.setText("Score " + gPanel.getScore());
	}
	
}
