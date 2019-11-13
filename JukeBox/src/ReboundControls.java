/*
 * ReboundControls.java -- This program helps control the ReboundPanel in either pausing or playing or changing the face of the face
 * Jason Melnik
 * CSC 120
 * 11/18/2018
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReboundControls extends JPanel{
	private ReboundPanel rebound;
	private JButton play;
	
	private String[] faceIcons = { "face1", "face2", "face3", "face4"};
	
	private ImageIcon image1, image2, image3, image4;
	
	private JComboBox faces;
	
	public ReboundControls(ReboundPanel reboundPanel) {
		rebound = reboundPanel;
		
		image1 = new ImageIcon("src/happyFace1.gif");
		image2 = new ImageIcon("src/happyFace2.gif");
		image3 = new ImageIcon("src/happyFace3.gif");
		image4 = new ImageIcon("src/happyFace4.gif");
		
		play = new JButton("Pause");
		faces = new JComboBox(faceIcons);
		
		play.addActionListener(new ButtonListener());
		faces.addActionListener(new BoxListener());
		
		add(play);
		add(faces);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == play) {
				if (play.getText().equals("Play"))
					play.setText("Pause");
				else
					play.setText("Play");
				ReboundPanel.setPause();
			}
		}
		
		
	}
	
	private class BoxListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			 JComboBox cb = (JComboBox)event.getSource();
		     String face = (String)cb.getSelectedItem();
		     if(face == "face1")
		    	 ReboundPanel.setFace(image1);
		     if(face == "face2")
		    	 ReboundPanel.setFace(image2);
		     if(face == "face3")
		    	 ReboundPanel.setFace(image3);
		     if(face == "face4")
		    	 ReboundPanel.setFace(image4);
		}
		
		
	}
}
