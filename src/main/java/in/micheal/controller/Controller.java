package in.micheal.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.service.AdminService;
import in.micheal.service.CustomerService;

public class Controller {

	private Controller() {
		// default constructor
	}

	/**
	 * This method is used to control Upload Books servlet
	 * 
	 * @param bookName
	 * @param bookQuantity
	 * @return
	 * @throws DbException
	 */
	public static String uploadBooksController(String bookName, int bookQuantity) throws DbException {
		BookDetail obj = new BookDetail();
		obj.setName(bookName);
		obj.setQuantity(bookQuantity);
		return AdminService.uploadBooks(obj);
	}

	/**
	 * This method is used to control TakeBook Servlet
	 * 
	 * @param bookName
	 * @param bookQuantity
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static String takeBookController(String bookName, int bookQuantity, long userId) throws DbException {
		DebtUserDetail debtUser = new DebtUserDetail();
		debtUser.setTakenBook(bookName);
		debtUser.setDebtUserId(userId);
		debtUser.setTekenBookQuantity(bookQuantity);

		ZoneId defaultZoneId = ZoneId.systemDefault();

		LocalDate localDate = LocalDate.now();
		
		

		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		debtUser.setTakenDate(date);

		return CustomerService.takeBook(debtUser);
	}
}
