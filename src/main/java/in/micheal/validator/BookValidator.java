package in.micheal.validator;

import java.util.List;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.exception.DbException;
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
	 * @throws DbException
	 */
	public static boolean bookRepetationChecker(String bookName) throws DbException {
		boolean confirmation = true;
		List<BookDetail> allBooks = BookDetailsDAO.findBook(bookName);
		if (allBooks.isEmpty()) {
			confirmation = false;

		}
		return confirmation;
	}

	/**
	 * This method returns true if the asked book Quantity is available or else
	 * returns false
	 * 
	 * @param actualQuantity
	 * @param bookIndex
	 * @return
	 * @throws DbException
	 */
	public static int bookQuantityValidator(String bookName, int neededBookQuantity) throws DbException {
		int bookQuantityInDB;
		int remainingBookInDB = 0;

		bookQuantityInDB = BookDetailsDAO.getBookQuantity(bookName);
		remainingBookInDB = bookQuantityInDB - neededBookQuantity;

		return remainingBookInDB;
	}

	public static int debtBookQuantityValidator(String bookName, long userId) throws DbException {
		int debtUserTakenBookQuantity;

		debtUserTakenBookQuantity = DebtUserDetailsDAO.getTakenBookQuantity(userId, bookName);

		return debtUserTakenBookQuantity;
	}
}
