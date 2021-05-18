package in.micheal.service;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.model.BookDetail;
import in.micheal.validator.BookValidator;

public class AdminService {

	/**
	 * This method is used to upload books in Admin Side
	 * 
	 * @param obj
	 * @return
	 */
	public static String uploadBooks(BookDetail obj) {
		String msg;
		int bookIndex = BookValidator.bookRepetationChecker(obj.getName());
		if (bookIndex == -1) {
			BookDetailsDAO.addBooks(obj);
			msg = "BOOK UPLOADED SUCCESSFULLY";
		} else {
			BookDetailsDAO.updateBooks(obj, bookIndex);
			msg = "BOOK UPDATED SUCCESSFULLY";
		}
		return msg;
	}
}
