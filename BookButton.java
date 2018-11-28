import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookButton extends JButton {

	private Book book;
	private BookInfoPanel infoPanel;

	public BookButton (Book book, BookInfoPanel infoPanel) {
		this.book = book;
		this.infoPanel = infoPanel;
		setText(book.getTitle());
		addActionListener(new ClickedActionListener());
	}
	
	private class ClickedActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			infoPanel.setBookInfo(book);
		}
	}

}
