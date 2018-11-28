import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BookListPanel extends JPanel {

	private JTextField importTextField;
	private JButton importButton;
	private Dimension size;
	private JScrollPane scrollPane;
	private JPanel bookListPanel;
	private JPanel importPanel;
	
	public BookListPanel(String title, int width, int height) {
		size = new Dimension(width, height);
		setLayout(new BorderLayout(0, 10));
		setPreferredSize(size);
		Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), title);
		Border border = BorderFactory.createCompoundBorder(titledBorder, new EmptyBorder(10, 5, 10, 5));
		setBorder(border);
		
		bookListPanel = new JPanel();
		bookListPanel.setLayout(new GridLayout(0, 1, 0, 10));
		
		scrollPane = new JScrollPane(bookListPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.validate();
		add(scrollPane, BorderLayout.CENTER);
		
		importPanel = new JPanel();
		importPanel.setLayout(new BorderLayout());
		
		importTextField = new JTextField();
		importTextField.setPreferredSize(new Dimension(size.width - 100, importTextField.getHeight()));
		importPanel.add(importTextField, BorderLayout.WEST);
		
		importButton = new JButton("Import");
		importPanel.add(importButton, BorderLayout.EAST);
		
		add(importPanel, BorderLayout.SOUTH);
	}
	
	public void setBookButtons(Book[] books, BookInfoPanel infoPanel) {
		bookListPanel.removeAll();
		for (int i = 0; i < books.length; ++i) {
			BookButton button = new BookButton(books[i], infoPanel);
			button.setPreferredSize(new Dimension(size.width - 50, 25));
			bookListPanel.add(button);
		}
	}
}
