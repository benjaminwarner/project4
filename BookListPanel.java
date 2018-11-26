import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

public class BookListPanel extends JPanel {

	private DefaultListModel model;
	private JList<String> books;
	private JTextField importTextField;
	private JButton importButton;
	private Dimension dimension;
	
	public BookListPanel(String title, int width, int height) {
		dimension = new Dimension(width, height);
		setLayout(new BorderLayout());
		setPreferredSize(dimension);
		Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), title);
		Border border = BorderFactory.createCompoundBorder(titledBorder, new EmptyBorder(10, 5, 10, 5));
		setBorder(border);
		
		addImportPanel();
		addBookList();
	}
	
	private void addImportPanel() {
		JPanel importPanel = new JPanel();
		importPanel.setLayout(new BorderLayout());
		importPanel.setMaximumSize(new Dimension(dimension.width, 45));
		
		importTextField = new JTextField();
		importTextField.setPreferredSize(new Dimension(dimension.width - 100, importTextField.getHeight()));
		importPanel.add(importTextField, BorderLayout.WEST);
		
		importButton = new JButton("Import");
		importPanel.add(importButton, BorderLayout.EAST);
		
		add(importPanel, BorderLayout.NORTH);
	}
	
	private void addBookList() {
		
		model = new DefaultListModel();
		books = new JList(model);
		books.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(books);
		scrollPane.setMinimumSize(new Dimension(dimension.width, dimension.height - 75));
		add(scrollPane, BorderLayout.SOUTH);
	}
	
	public void setBooks(String[] books) {
		model.clear();
		for (int i = 0; i < books.length; ++i) {
			model.addElement(books[i]);
		}
	}
}
