import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class defines what a book is. It's made up
 * of a title, author, genre, and a filepath. 
 * 
 * @author Benjamin Warner
 *
 */

public class Book implements BookInterface {
	private String title;
	private String author;
	private String genre;
	private String filename;
	
	/**
	 * Creates a book object from just a title and author.
	 * 
	 * @param title - The title of the book
	 * @param author - The author of the book
	 */
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	/**
	 * Creates a book object from title, author, genre, and filename.
	 * 
	 * @param title - The title of the book
	 * @param author - The author of the book
	 * @param genre - The genre of the book
	 * @param filename - Full path to a .txt file that contains the contents of the book
	 */
	public Book(String title, String author, String genre, String filename) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.filename = filename;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String getFilename() {
		return this.filename;
	}

	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public boolean isValid() {
		return this.title != null && this.author != null && this.genre != null && this.filename != null && new File(filename).isFile();
	}

	@Override
	public String getText() {
		if (!isValid())
			return null;
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(this.filename));
			return String.join("\n", lines);
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * Return the string representation of the book; prints title, author, genre, and filepath respectively
	 */
	public String toString() {
		return String.format("Title: %-35sAuthor: %-25sGenre: %-12sFilepath: %s", title, author, genre, filename);
	}
}
