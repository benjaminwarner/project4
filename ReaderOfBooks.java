import javax.swing.JFrame;

public class ReaderOfBooks {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Read some books yo!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReaderOfBooksPanel root = new ReaderOfBooksPanel();
		frame.getContentPane().add(root);
		
		frame.pack();
		frame.setVisible(true);
	}

}
