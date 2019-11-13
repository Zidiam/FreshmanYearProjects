import javax.swing.JFrame;
public class GCDandBlurbGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Greatest Common Divider Calculator and Blurb Word Maker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GCDandBlurbPanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
