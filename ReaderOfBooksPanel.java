import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReaderOfBooksPanel extends JPanel {
	
	private ReaderPanel readerPanel;
	private LibraryPanel libraryPanel;
	private Dimension size = new Dimension(1200, 500);
	
	private Library library = new Library();
	private String defaultPath = "./etext/booklist-full.csv";

	public ReaderOfBooksPanel() {
		
		setPreferredSize(size);
		setLayout(new BorderLayout());
		
		libraryPanel = new LibraryPanel(500, size.height);
		add(libraryPanel, BorderLayout.WEST);
		
		readerPanel = new ReaderPanel(size.width - 500, size.height);
		add(readerPanel, BorderLayout.EAST);
	}
	
	private class BookButtonClickedListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String title = ((JButton)e.source).getText();
			Book book = library.getBook(title);
			readerPanel.setSelectedBook(book);
		}
	}
}
