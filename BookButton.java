import javax.swing.*;

public class BookButton extends JButton {

	public BookButton (Book book) {
		setText(book.getTitle());
	}

}
