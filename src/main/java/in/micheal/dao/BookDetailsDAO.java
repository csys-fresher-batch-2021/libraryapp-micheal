package in.micheal.dao;

import in.micheal.model.BookDetail;
import java.util.ArrayList;
import java.util.List;

public class BookDetailsDAO {
	private BookDetailsDAO() {
		// default constructor
	}

	private static final List<BookDetail> bookDetails = new ArrayList<>();

	static {
		BookDetail book1 = new BookDetail();
		book1.setName("JAVA");
		book1.setQuantity(20);

		BookDetail book2 = new BookDetail();
		book2.setName("PYTHON");
		book2.setQuantity(10);

		bookDetails.add(book1);
		bookDetails.add(book2);
	}

	/**
	 * This method is used to get Book Details
	 * 
	 * @return
	 */
	public static List<BookDetail> getBookDetails() {
		return bookDetails;
	}

}
