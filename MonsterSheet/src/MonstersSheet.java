import javax.swing.JFrame;

/*
 * ZooSheet.java -- Displays a GUI in everything a Zoo Keeper needs
 * Jason Melnik
 * 1/28/2019
 */
public class MonstersSheet {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Monster Sheet");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new MonsterSheetPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
