package in.micheal.service;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.validator.BookValidator;
import in.micheal.validator.DebtUserValidator;

public class CustomerService {
	private CustomerService() {
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
			boolean confirmation = BookValidator.bookQuantityValidator(obj.getQuantity(), index);
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

	/**
	 * This method is used return the books and update debtUserDetails and
	 * BookDetails
	 * 
	 * @param book
	 * @param userObj
	 * @return
	 */

	public static String returnBook(BookDetail book, DebtUserDetail userObj) {
		String confirmation = null;
		int debtUserIndex = DebtUserValidator.isDebtUser(userObj);
		int bookIndex = BookValidator.bookRepetationChecker(book.getName());
		if (debtUserIndex == -1) {
			confirmation = "YOU DIDNT TOOK THIS BOOK";
		} else {
			int remainingBook = BookValidator.validateBookQuantity(book.getQuantity(), debtUserIndex);
			if (remainingBook < 0) {
				confirmation = "YOUR RETURNING TOO MUCH BOOKS";
			} else if (remainingBook > 0) {
				confirmation = "YOU RETURNED SOME BOOKS";
				DebtUserDetailsDAO.subDebtQuantity(remainingBook, debtUserIndex);
				BookDetailsDAO.addBookQuantity(book, bookIndex);

			} else if (remainingBook == 0) {
				confirmation = "YOU RETURNED ALL BOOKS";
				DebtUserDetailsDAO.subDebtQuantity(remainingBook, debtUserIndex);
				BookDetailsDAO.addBookQuantity(book, bookIndex);
			}
		}
		return confirmation;

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
