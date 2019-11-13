import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class McDonaldsPanel extends JPanel{
	
	private final int WIDTH = 1200, HEIGHT = 1000;
	private int speed = 75;
	private Timer timer;
	private SButton breakfast1, lunch1;
	private JLabel breakfast2, lunch2;
	
	public McDonaldsPanel() {
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());

		setupButtons();
		setupLabels();
		
		setLayout(null);
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
	}
	
	public void setupLabels() {
		breakfast2 = new JLabel("Breakfast 2");
		lunch2 = new JLabel("Lunch 2");
		
		breakfast2.setBounds(67, 215, 100, 25);
		lunch2.setBounds(150, 215, 100, 25);
		
		add(breakfast2);
		add(lunch2);
	}
	
	public void setupButtons() {
		breakfast1 = new SButton(new ImageIcon("src//Images//yellow.png"));
		lunch1 = new SButton("Lunch 1");
		
		
		breakfast1.setBounds(50, 190, 100, 100);
		lunch1.setBounds(200, 190, 100, 100);
		
		breakfast1.addActionListener(new ButtonListener());
		lunch1.addActionListener(new ButtonListener());
		
		breakfast1.setBorderPainted(false);
		lunch1.setBorderPainted(false);
		
		breakfast1.setBackground(null);
		lunch1.setBackground(Color.blue);
		
		add(breakfast1);
		add(lunch1);
		
	}
	
	public void paintButtons(Graphics page) {
		page.setColor(Color.YELLOW);
		
		
		
		
		
		page.setColor(Color.BLACK);
		
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		paintButtons(page);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == breakfast1) {
				System.out.println("bf1");
			}
		}
	}
	
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {
				//do something
			}
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	
	private class ReboundListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction
		//  of movement whenever the timer fires an action event.
		//--------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			//happens over and over again
		}
	}
}
	
	

