import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class BookInfoPanel extends JPanel {

	private JLabel author;
	private JLabel title;
	private JLabel genre;
	private JLabel filePath;
	
	public BookInfoPanel(String title, int width, int height) {
		setLayout(new GridLayout(4, 2));
		setPreferredSize(new Dimension(width, height));
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), title);
		setBorder(border);
		
		add(new JLabel("Title: "));
		this.title = new JLabel("<TITLE>");
		add(this.title);
		
		add(new JLabel("Author: "));
		author = new JLabel("<AUTHOR>");
		add(author);
		
		add(new JLabel("Genre: "));
		genre = new JLabel("<GENRE>");
		add(genre);
		
		add(new JLabel("Filepath: "));
		filePath = new JLabel("<FILEPATH>");
		add(filePath);
	}
	
	public void setBookInfo(Book book) {
		title.setText(book.getTitle());
		author.setText(book.getAuthor());
		genre.setText(book.getGenre());
		filePath.setText(book.getFilename());
	}

}
