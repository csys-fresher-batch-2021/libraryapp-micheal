package in.micheal.service;

import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.validator.BookQuantityValidator;
import in.micheal.validator.BookValidator;
import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;

public class TakeOrReturnBook {
	private TakeOrReturnBook() {
		// default constructor
	}

	/**
	 * This method used Take book and returns string statement according to the
	 * input
	 * 
	 * @param obj
	 * @param userobj
	 * @return
	 */
	public static String takeBook(BookDetail obj, DebtUserDetail userobj) {
		String verification;

		int index = BookValidator.bookRepetationChecker(obj.getName());
		if (index != -1) {
			boolean confirmation = BookQuantityValidator.bookQuantityValidator(obj.getQuantity(), index);
			if (confirmation) {

				BookDetailsDAO.subBookQuantity(obj, index);
				DebtUserDetailsDAO.addDebtUsers(userobj);
				verification = "BOOK TAKEN SUCCESSFULLY";
			} else {
				verification = "SORRY INSUFFICIENT BOOK";
			}

		} else {
			verification = "SORRY BOOK NOT AVAILABLE";
		}

		return verification;
	}
}
