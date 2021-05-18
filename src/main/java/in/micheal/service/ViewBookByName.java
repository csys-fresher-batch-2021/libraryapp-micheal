package in.micheal.service;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.model.BookDetail;
import in.micheal.validator.BookValidator;

public class ViewBookByName {

	private ViewBookByName() {
		// default constructor
	}

	/**
	 * This method returns the object in with the given parameter is present or else
	 * returns null
	 * 
	 * @param bookname
	 * @return
	 */
	public static BookDetail bookName(String bookname) {
		String bookName = bookname.toUpperCase();
		BookDetail obj;
		int index = BookValidator.bookRepetationChecker(bookName);
		if (index > -1) {
			obj = BookDetailsDAO.getBookDetails().get(index);
		} else {
			obj = null;
		}
		return obj;
	}

}
