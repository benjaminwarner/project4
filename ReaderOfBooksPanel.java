import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class ReaderOfBooksPanel extends JPanel {
	
	private ReaderPanel reader;
	private LibraryPanel library;
	private Dimension size = new Dimension(900, 900);

	public ReaderOfBooksPanel() {
		
		setPreferredSize(size);
		setLayout(new BorderLayout());
		
		library = new LibraryPanel(size.width, 225);
		add(library, BorderLayout.NORTH);
		
		reader = new ReaderPanel(size.width, size.height - 400);
		add(reader, BorderLayout.SOUTH);
	}
}
