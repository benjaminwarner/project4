import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class LibraryPanel extends JPanel {
	
	private BookListPanel bookList;
	private BookInfoPanel bookInfo;
	private Scanner csvParser;
	
	private Library library = new Library();
	private String defaultCsvPath = "./etext/booklist-full.csv";

	public LibraryPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setLayout(new BorderLayout());
		
		bookList = new BookListPanel("Library", width / 2, height);
		add(bookList, BorderLayout.WEST);
		
		bookInfo = new BookInfoPanel("Book Info", width / 2, height - 100);
		add(bookInfo, BorderLayout.EAST);
		
		loadBooksFromCsv(defaultCsvPath);
		setBookList();
	}
	
	private void loadBooksFromCsv(String path) {
		library.clearBooks();
		library.loadLibraryFromCSV(path);
	}
	
	private void setBookList() {
		String[] availableBooks = new String[library.size()];
		for (int i = 0; i < library.size(); ++i) {
			availableBooks[i] = library.getBook(i).getTitle();
		}
		bookList.setBooks(availableBooks);
	}
}
