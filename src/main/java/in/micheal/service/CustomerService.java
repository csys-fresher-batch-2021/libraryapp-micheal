package in.micheal.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.dao.DebtUsersFineDAO;
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
		boolean isFinedUser = DebtUserValidator.getFineAmount(userobj.getDebtUserId());
		String verification = null;
		if (!isFinedUser) {
			int remainingBookInDB;

			remainingBookInDB = BookValidator.bookQuantityValidator(userobj.getTakenBook(),
					userobj.getTekenBookQuantity());
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
					DebtUserDetailsDAO.updateBookQuantity(userobj.getTakenBook(), remDebtBooks,
							userobj.getDebtUserId());
					verification = "BOOK TAKEN SUCCESSFULLY";
				}
			} else {
				verification = "SORRY INSUFFICIENT BOOK";
			}
		} else {
			verification = "PLEASE MEET THE ADMIN AND PAY THE FINE ";
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
			confirmation = "YOUR RETURNING TOO MUCH BOOKS,NOT ACCEPTABLE";
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
	 * This method is used to calculate fin for debt users and automatically update
	 * it to the databse
	 * 
	 * @param userId
	 * @throws DbException
	 */
	public static void autoCalculateFine() throws DbException {
		List<Long> allDebtUser = DebtUserDetailsDAO.getAllUser();

		for (int i = 0; i < allDebtUser.size(); i++) {
			long userId = allDebtUser.get(i);
			List<DebtUserDetail> searchResults = DebtUserDetailsDAO.getDebtUserOfId(userId);
			LocalDate currentDate = LocalDate.now();
			int totalFine = 0;
			for (DebtUserDetail obj : searchResults) {
				long fineAmount = 0;

				long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(obj.getTakenDate().toString()),
						currentDate);
				if (noOfDaysBetween > 3) {
					Long fineDay = noOfDaysBetween - 3;
					fineAmount = fineDay * DebtUserDetailsDAO.getTakenBookQuantity(userId, obj.getTakenBook()) * 5;
					totalFine += fineAmount;
				}
			}
			boolean isFinedUser = DebtUserValidator.isFinedUser(userId);
			if (!isFinedUser) {
				DebtUsersFineDAO.putFineAmount(userId, totalFine);
			} else {
				DebtUsersFineDAO.updateFineAmount(userId, totalFine);
			}
		}

	}

}
