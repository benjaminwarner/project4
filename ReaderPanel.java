import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ReaderPanel extends JPanel {
	
	public ReaderPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Reader");
		Border border = BorderFactory.createCompoundBorder(titledBorder, new EmptyBorder(10, 5, 10, 5));
		setBorder(border);
	}

}
