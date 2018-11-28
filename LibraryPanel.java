import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class LibraryPanel extends JPanel {
	
	private BookListPanel bookList;
	private BookInfoPanel bookInfo;
	private Scanner csvParser;

	public LibraryPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setLayout(new BorderLayout());
		
		bookList = new BookListPanel("Library", width / 2, height);
		add(bookList, BorderLayout.WEST);
		
		bookInfo = new BookInfoPanel("Book Info", width / 2, height);
		add(bookInfo, BorderLayout.EAST);
	}
	
	private void setBookList() {
		Book[] books = new Book[library.size()];
		bookList.setBookButtons(library.getBooks().toArray(books), bookInfo);
	}
}
