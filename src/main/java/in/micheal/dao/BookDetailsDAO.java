package in.micheal.dao;

import in.micheal.model.BookDetails;
import java.util.ArrayList;
import java.util.List;

public class BookDetailsDAO {
	private BookDetailsDAO() {
		// default constructor
	}

	public static final List<BookDetails> bookDetails = new ArrayList<BookDetails>();

	static {
		BookDetails book1 = new BookDetails();
		book1.setBookName("JAVA");
		book1.setbookQuantity(20);

		BookDetails book2 = new BookDetails();
		book2.setBookName("PYTHON");
		book2.setbookQuantity(10);

		bookDetails.add(book1);
		bookDetails.add(book2);
	}

	/**
	 * This method is used to get Book Details
	 * 
	 * @return
	 */
	public static List<BookDetails> getBookDetails() {
		return bookDetails;
	}

}
