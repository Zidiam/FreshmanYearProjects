import javax.swing.JFrame;

/*
 * LayoutManagrApp.java -- Sheet for animals
 * Jason Melnik
 */
public class LayoutManagrApp {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Animal Data Entry");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.getContentPane().add(new LayoutManager());
	    myFrame.pack();
	    myFrame.setVisible(true);
    
    
}
}