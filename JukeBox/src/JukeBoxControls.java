/*
 * JukeBoxControls.java --  This is the panel that contains the JCommboBox, JPanel for the buttons and pictures, 
 * it also the code that lets ou be able to click on the buttons or keys to play or pause a song.
 * Jason Melnik
 * CSC 120
 * 11/18/2018
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


public class JukeBoxControls extends JPanel {

	private JComboBox<String> musicCombo;
	private JButton stopButton, playButton;
	private File[] musicFile;
	private File current;
	private AudioInputStream audioStream;
	private JPanel buttonPanel, imagePanel;
	private Clip audioClip;
	private ImageIcon currentImg, artist1, artist2, artist3, artist4, artist5, artist6, noartist;
	
	public JukeBoxControls() {
		ImageLoader();
		currentImg = new ImageIcon();
		currentImg = noartist;
		imagePanel = new JPanel();
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(250, 45));
		imagePanel.setPreferredSize(new Dimension(250, 250));
		
		File f1, f2, f3, f4, f5, f6;
		f1 = f2 = f3 = f4 = f5 = f6 = null;
		// get the audio clips if we can!
		try {
			f1 = new File("src\\AloneSong.wav");
			f2 = new File("src\\NoahSong.wav");
			f3 = new File("src\\MileySong.wav");
			f4 = new File("src\\TaylorSong.wav");
			f5 = new File("src\\eminemSong.wav");
			f6 = new File("src\\LanaSong.wav");
		} catch (Exception e) {
			System.err.println("Houston, we have a problem.");
		}
		musicFile = new File[7];
		musicFile[0] = null;
		musicFile[1] = f1;
		musicFile[2] = f2;
		musicFile[3] = f3;
		musicFile[4] = f4;
		musicFile[5] = f5;
		musicFile[6] = f6;

		String[] musicNames = { "Pick some jams!", "Alone by Alan Walker", "Stay Together by Noah Cyrus", "Malibu by Miley Cyrus",
				"New Years Day by Taylor Swift", "The Real Slim Shady by Eminem", "High by the beach by Lana" };

		musicCombo = new JComboBox<String>(musicNames);
		musicCombo.setBackground(Color.CYAN);

		playButton = new JButton("Play", new ImageIcon("src//play25x25.png"));
		playButton.setBackground(Color.CYAN);
		stopButton = new JButton("Stop", new ImageIcon("src//stop25x25.png"));
		stopButton.setBackground(Color.CYAN);

		setPreferredSize(new Dimension(250, 345));
		setBackground(Color.CYAN);
		buttonPanel.add(playButton);
		buttonPanel.add(stopButton);
		imagePanel.add(new JLabel(currentImg));
		add(musicCombo);
		add(imagePanel);
		add(buttonPanel);
		
		
		musicCombo.addActionListener(new ComboListener());
		stopButton.addActionListener(new ButtonListener());
		playButton.addActionListener(new ButtonListener());
		
		playButton.setMnemonic('P');
		stopButton.setMnemonic('S');
		
		current = null;
	}
	
	public void ImageLoader() {
		ImageIcon test = new ImageIcon("src\\AloneImg.png");
		Image img = test.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		artist1 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\NoahImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		artist2 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\MileyImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		artist3 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\TaylorImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		artist4 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\EminemImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		artist5 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\LanaImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		artist6 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\noSongImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 250, null);
		noartist = new ImageIcon(bi);
	}
	private class ComboListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				if (current != null) {
					audioClip.close();
					audioStream.close();
				}
				current = musicFile[musicCombo.getSelectedIndex()];
				if (current != null) {
					audioStream = AudioSystem.getAudioInputStream(current);
					AudioFormat format = audioStream.getFormat();
					DataLine.Info info = new DataLine.Info(Clip.class, format);
					audioClip = (Clip) AudioSystem.getLine(info);
					audioClip.open(audioStream);
					JComboBox cb = (JComboBox)e.getSource();
				    String pick = (String)cb.getSelectedItem();
				    System.out.println(pick);
				    if(pick.equals("Pick some jams!")) {
				    	imagePanel.removeAll();
				    	currentImg = noartist;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
				    if(pick.equals("Alone by Alan Walker")) {
				    	imagePanel.removeAll();
				    	currentImg = artist1;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
				    if(pick.equals("Stay Together by Noah Cyrus")) {
				    	imagePanel.removeAll();
				    	currentImg = artist2;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
				    
				    if(pick.equals("Malibu by Miley Cyrus")) {
				    	imagePanel.removeAll();
				    	currentImg = artist3;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
				    
				    if(pick.equals("New Years Day by Taylor Swift")) {
				    	imagePanel.removeAll();
				    	currentImg = artist4;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
				    
				    if(pick.equals("The Real Slim Shady by Eminem")) {
				    	imagePanel.removeAll();
				    	currentImg = artist5;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
				    
				    if(pick.equals("High by the beach by Lana")) {
				    	imagePanel.removeAll();
				    	currentImg = artist6;
				    	imagePanel.add(new JLabel(currentImg));
				    	imagePanel.revalidate();
				    	imagePanel.repaint();
				    	
				    }
			
				}
			} catch (IOException exception) {
				System.err.println(exception);
			} catch (UnsupportedAudioFileException exception) {
				System.err.println(exception);
			} catch (LineUnavailableException exception) {
				System.err.println(exception);
			}
		}

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (current != null)
				audioClip.stop();

			if (e.getSource() == playButton) {
				if (current != null)
					audioClip.start();
			}
		}
	}
}
	

