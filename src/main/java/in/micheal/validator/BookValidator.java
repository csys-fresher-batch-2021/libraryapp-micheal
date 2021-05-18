package in.micheal.validator;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.model.BookDetail;

public class BookValidator {
	private BookValidator() {
		// default constructor
	}

	/**
	 * This methods return the index of the given book name in bookDetails else
	 * returns -1
	 * 
	 * @param bookName
	 * @return
	 */
	public static int bookRepetationChecker(String bookName) {
		int index = -1;
		for (BookDetail obj : BookDetailsDAO.getBookDetails()) {
			if (obj.getName().equals(bookName)) {
				index = BookDetailsDAO.getBookDetails().indexOf(obj);
			}
		}
		return index;
	}
}
