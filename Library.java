import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Library class is built up of Book objects.
 * It provides an API to add, remove, and find books.
 * The find mechanism works by either index or title.
 * The dependency on the Book class is an aggregate one.
 * 
 * @author benjaminwarner
 *
 */

public class Library implements LibraryInterface {
	private ArrayList<Book> books;
	
	/**
	 * Create a new Library object
	 */
	public Library() {
		this.books = new ArrayList<Book>();
	}
	
	public int size() {
		return this.books.size();
	}

	@Override
	public ArrayList<Book> getBooks() {
		return (ArrayList<Book>)this.books.clone();
	}

	@Override
	public void addBook(Book newBook) {
		this.books.add(newBook);
	}

	@Override
	public void removeBook(int index) {
		if (index >= this.books.size())
			return;
		this.books.remove(index);
	}

	public void removeBook(Book book) {
		this.books.remove(book);
	}

	@Override
	public Book getBook(int index) {
		if (index >= this.books.size())
			return null;
		return this.books.get(index);
	}

	/**
	 * Find a book in the library that equals the supplied title.
	 * If there are multiple books in the library with the same title,
	 * the first one found wins.
	 * 
	 * @param title - title of the book to search for
	 * @return The found book with a matching title, null otherwise
	 */
	public Book getBook(String title) {
		for (Book b : this.books)
			if (b.getTitle().equals(title))
				return b;
		return null;
	}
	
	/**
	 * Remove all books from the library
	 */
	public void clearBooks() {
		this.books.clear();
	}
	
	/**
	 * Return string representation of all the books in the library with their index
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < this.books.size(); ++i) {
			Book book = this.books.get(i);
			str += String.format("Index: %-7d%s\n", i, book.toString());
		}
		return str;
	}

	@Override
	public void loadLibraryFromCSV(String csvFilename) {
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(csvFilename));
			Scanner csvParser;
			for (String line : lines) {
				csvParser = new Scanner(line);
				csvParser.useDelimiter(",");
				String title = csvParser.next();
				String author = csvParser.next();
				String genre = csvParser.next();
				String filePath = csvParser.next();
				this.addBook(new Book(title, author, genre, filePath));
			}
		} catch (IOException e) {
			System.out.println(String.format("Failed to open the csv %s for parsing", csvFilename));
		}
	}
}
