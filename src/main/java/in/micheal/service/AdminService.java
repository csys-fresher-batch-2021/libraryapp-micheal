package in.micheal.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.model.DebtUserDetail;
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

	/**
	 * This method return all records in debtuser data base
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<DebtUserDetail> getAllDebtRecords() throws DbException {
		return DebtUserDetailsDAO.getAllRecords();

	}

	/**
	 * This function is used to update the date in debtuser databse
	 * 
	 * @param userId
	 * @param bookName
	 * @throws DbException
	 */
	public static void payFine(long userId, String bookName) throws DbException {
		Date date = Date.valueOf(LocalDate.now());
		DebtUserDetailsDAO.updateDate(userId, date, bookName);
	}
}
