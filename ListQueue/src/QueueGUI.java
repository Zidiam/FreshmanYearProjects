import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

public class QueueGUI {
    public static void main(String[] args) {
    	JFrame myFrame = new JFrame("Customer GUI");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.getContentPane().add(new QueuePanel());
	    myFrame.pack();
	    myFrame.setVisible(true);
    }
}