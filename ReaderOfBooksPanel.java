import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class ReaderOfBooksPanel extends JPanel {
	
	private ReaderPanel reader;
	private LibraryPanel library;
	private Dimension size = new Dimension(1200, 500);

	public ReaderOfBooksPanel() {
		
		setPreferredSize(size);
		setLayout(new BorderLayout());
		
		library = new LibraryPanel(500, size.height);
		add(library, BorderLayout.WEST);
		
		reader = new ReaderPanel(size.width - 500, size.height);
		add(reader, BorderLayout.EAST);
	}
}
