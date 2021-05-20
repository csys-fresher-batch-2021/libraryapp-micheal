package in.micheal.validator;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
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

	public static int validateBookQuantity(int bookQuantity, int debtBookIndex) {
		return (DebtUserDetailsDAO.getDebtUserDetail().get(debtBookIndex).getTekenBookQuantity()) - bookQuantity;
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
