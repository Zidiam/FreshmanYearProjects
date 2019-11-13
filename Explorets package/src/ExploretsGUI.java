import javax.swing.JFrame;

/*
 * ExploretsGUI.java -- Game
 * Jason Melnik
 * CSC 120
 * 5/28/2019
 */
public class ExploretsGUI{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Explorets");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new ExploretsPanel());
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
