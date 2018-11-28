import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ReaderPanel extends JPanel {

	private Dimension size;
	
	public ReaderPanel(int width, int height) {
		size = new Dimension(width, height);
		setPreferredSize(size);
		Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Reader");
		Border border = BorderFactory.createCompoundBorder(titledBorder, new EmptyBorder(10, 5, 10, 5));
		setBorder(border);
	}
	
	public void setSelectedBook(Book book) {
	}

}
