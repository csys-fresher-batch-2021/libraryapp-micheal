package in.micheal.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.validator.BookValidator;
import in.micheal.validator.DebtUserValidator;

public class CustomerService {
	private CustomerService() {
		// default constructor
	}

	/**
	 * This method is used to take books ,This method updates the debt User
	 * DataBase,BookDetails Databse according to the quantity of book input
	 * 
	 * input
	 * 
	 * @param obj
	 * @param userobj
	 * @return
	 * @throws DbException
	 */
	public static String takeBook(DebtUserDetail userobj) throws DbException {
		String verification = null;
		int remainingBookInDB;

		remainingBookInDB = BookValidator.bookQuantityValidator(userobj.getTakenBook(), userobj.getTekenBookQuantity());
		if (remainingBookInDB > 0) {
			boolean confirmation;

			confirmation = DebtUserValidator.isDebtUser(userobj.getDebtUserId(), userobj.getTakenBook());

			if (!confirmation) {

				DebtUserDetailsDAO.addDebtUsers(userobj);
				BookDetailsDAO.updateBookQuantity(userobj.getTakenBook(), remainingBookInDB);

				verification = "BOOK TAKEN SUCCESSFULLY";
			} else {

				BookDetailsDAO.updateBookQuantity(userobj.getTakenBook(), remainingBookInDB);
				int debtUserTakenBook = DebtUserDetailsDAO.getTakenBookQuantity(userobj.getDebtUserId(),
						userobj.getTakenBook());
				int remDebtBooks = userobj.getTekenBookQuantity() + debtUserTakenBook;
				DebtUserDetailsDAO.updateBookQuantity(userobj.getTakenBook(), remDebtBooks, userobj.getDebtUserId());
				verification = "BOOK TAKEN SUCCESSFULLY";
			}
		} else {
			verification = "SORRY INSUFFICIENT BOOK";
		}

		return verification;
	}

	/**
	 * This method is used return the books , This method updates Debt User
	 * Database,bookDetail Database according to the input
	 * 
	 * @param book
	 * @param userObj
	 * @return
	 * @throws DbException
	 */

	public static String returnBook(DebtUserDetail userObj) throws DbException {
		String confirmation = null;
		long fineAmount = CustomerService.calculateFine(userObj.getDebtUserId(), userObj.getTakenBook());
		if (fineAmount == 0) {
			boolean isDebtUser = false;
			int takenBookQuantity = 0;

			isDebtUser = DebtUserValidator.isDebtUser(userObj.getDebtUserId(), userObj.getTakenBook());
			if (!isDebtUser) {

				confirmation = "YOU DIDNT TOOK THIS BOOK";
			} else {

				takenBookQuantity = DebtUserDetailsDAO.getTakenBookQuantity(userObj.getDebtUserId(),
						userObj.getTakenBook());

			}
			int remainingBook = takenBookQuantity - userObj.getTekenBookQuantity();
			if (remainingBook < 0) {
				confirmation = "YOUR RETURNING TOO MUCH BOOKS";
			} else if (remainingBook > 0) {
				confirmation = "YOU RETURNED SOME BOOKS";
				int bookQuantityInBookDb = BookDetailsDAO.getBookQuantity(userObj.getTakenBook())
						+ userObj.getTekenBookQuantity();
				BookDetailsDAO.updateBookQuantity(userObj.getTakenBook(), bookQuantityInBookDb);
				DebtUserDetailsDAO.updateBookQuantity(userObj.getTakenBook(), remainingBook, userObj.getDebtUserId());

			} else if (remainingBook == 0) {
				confirmation = "YOU RETURNED ALL BOOKS";
				DebtUserDetailsDAO.deleteDebtUser(userObj.getDebtUserId(), userObj.getTakenBook());
				int bookQuantityInBookDb = BookDetailsDAO.getBookQuantity(userObj.getTakenBook())
						+ userObj.getTekenBookQuantity();
				BookDetailsDAO.updateBookQuantity(userObj.getTakenBook(), bookQuantityInBookDb);

			}
		} else {
			confirmation = "PLEASE PAY THE FINE FOR DELAYING THE RETURNING OF THE BOOKS";
		}
		return confirmation;

	}

	/**
	 * This method is used toget all book according to the input book name from the
	 * data base
	 * 
	 * @param bookName
	 * @return
	 * @throws DbException
	 */
	public static List<BookDetail> getBooks(String bookName) throws DbException {
		List<BookDetail> searchResults;

		searchResults = BookDetailsDAO.searchBook(bookName);

		return searchResults;

	}

	/**
	 * Method overriding concept for getting Debt Books
	 * 
	 * @param debtUserId
	 * @return
	 * @throws DbException
	 */
	public static List<BookDetail> getBooks(long debtUserId) throws DbException {

		List<BookDetail> debtBooks;

		debtBooks = DebtUserDetailsDAO.searchBooks(debtUserId);

		return debtBooks;
	}

	/**
	 * This method is used to calculate fine amount of a indivduals
	 * @param userId
	 * @param bookName
	 * @return
	 * @throws DbException
	 */
	public static Long calculateFine(Long userId, String bookName) throws DbException {
		String bookTakenDate = DebtUserDetailsDAO.getDate(userId, bookName).toString();
		String currentDate = LocalDate.now().toString();
		long fineAmount = 0;

		LocalDate takenDate = LocalDate.parse(bookTakenDate);
		LocalDate currDate = LocalDate.parse(currentDate);

		long noOfDaysBetween = ChronoUnit.DAYS.between(takenDate, currDate);
		if (noOfDaysBetween > 3) {
			Long fineDay = noOfDaysBetween - 3;
			fineAmount = fineDay * DebtUserDetailsDAO.getTakenBookQuantity(userId, bookName) * 5;
		}
		return fineAmount;
	}

}
