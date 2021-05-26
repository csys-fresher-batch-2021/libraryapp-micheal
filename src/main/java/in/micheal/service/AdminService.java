package in.micheal.service;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.validator.BookValidator;

public class AdminService {

	private AdminService() {
		// default constructor
	}

	/**
	 * This method is used to upload books in Admin Side
	 * 
	 * @param obj
	 * @return
	 * @throws DbException
	 */
	public static String uploadBooks(BookDetail obj) throws DbException {
		String msg;
		boolean confirmation = BookValidator.bookRepetationChecker(obj.getName());
		if (confirmation) {
			int booksInDb = BookDetailsDAO.getBookQuantity(obj.getName());
			int bookToBeUpdated = booksInDb + obj.getQuantity();
			BookDetailsDAO.updateBookQuantity(obj.getName(), bookToBeUpdated);
			msg = "BOOK UPDATED SUCCESSFULLY";
		} else {
			BookDetailsDAO.addBooks(obj);

			msg = "BOOK UPLOADED SUCCESSFULLY";
		}

		return msg;
	}
}
