package in.micheal.dao;

import in.micheal.model.BookDetail;
import java.util.ArrayList;
import java.util.List;

public class BookDetailsDAO {
	private BookDetailsDAO() {
		// default constructor
	}

	private static final List<BookDetail> bookDetails = new ArrayList<>();

	/**
	 * This method is used to get Book Details
	 * 
	 * @return
	 */
	public static List<BookDetail> getBookDetails() {
		return bookDetails;
	}

	public static void addBooks(BookDetail obj) {
		bookDetails.add(obj);
	}

	public static void addBookQuantity(BookDetail obj, int bookIndex) {
		BookDetail bookObj = bookDetails.get(bookIndex);
		bookObj.setQuantity(bookObj.getQuantity() + obj.getQuantity());

	}

	public static void subBookQuantity(BookDetail obj, int bookIndex) {
		BookDetail bookObj = bookDetails.get(bookIndex);
		bookObj.setQuantity(bookObj.getQuantity() - obj.getQuantity());

	}

	public static void deleteAllBooks() {
		bookDetails.clear();
	}

}
