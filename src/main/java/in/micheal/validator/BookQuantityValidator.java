package in.micheal.validator;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.model.BookDetail;

public class BookQuantityValidator {
	private BookQuantityValidator() {
		// default constructor
	}

	/**
	 * This method returns true if the asked book Quantity is available or else
	 * returns false
	 * 
	 * @param actualQuantity
	 * @param bookIndex
	 * @return
	 */
	public static boolean bookQuantityValidator(int actualQuantity, int bookIndex) {
		boolean confirmation = false;
		BookDetail bookObj = BookDetailsDAO.getBookDetails().get(bookIndex);
		int bookQuantity = bookObj.getQuantity() - actualQuantity;
		if (bookQuantity > 0) {
			confirmation = true;
		}
		return confirmation;
	}

}
