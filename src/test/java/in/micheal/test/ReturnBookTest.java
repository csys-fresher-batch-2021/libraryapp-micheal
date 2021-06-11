package in.micheal.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.dao.DebtUserDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.service.AdminService;
import in.micheal.service.CustomerService;

public class ReturnBookTest {

	@Test
	public void returningSomeBooks() {

		try {
			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();

			BookDetail book1 = new BookDetail();
			book1.setName("SCIENCE");
			book1.setQuantity(20);

			AdminService.uploadBooks(book1);

			BookDetail book2 = new BookDetail();
			book2.setName("MATHS");
			book2.setQuantity(20);

			AdminService.uploadBooks(book2);

			DebtUserDetail debtUser = new DebtUserDetail();

			debtUser.setTakenBook("SCIENCE");
			debtUser.setDebtUserId(858585);
			debtUser.setTekenBookQuantity(10);

			ZoneId defaultZoneId = ZoneId.systemDefault();

			LocalDate localDate = LocalDate.now();

			Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			debtUser.setTakenDate(date);

			CustomerService.takeBook(debtUser);

			DebtUserDetail returningUser = new DebtUserDetail();

			returningUser.setTakenBook("SCIENCE");
			returningUser.setDebtUserId(858585);
			returningUser.setTekenBookQuantity(5);

			String confirmation = null;

			confirmation = CustomerService.returnBook(returningUser);

			assertEquals("YOU RETURNED SOME BOOKS", confirmation);

			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void returningManyBooks() {

		try {
			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();

			BookDetail book1 = new BookDetail();
			book1.setName("SCIENCE");
			book1.setQuantity(20);

			AdminService.uploadBooks(book1);

			BookDetail book2 = new BookDetail();
			book2.setName("MATHS");
			book2.setQuantity(20);

			AdminService.uploadBooks(book2);

			DebtUserDetail debtUser = new DebtUserDetail();

			debtUser.setTakenBook("SCIENCE");
			debtUser.setDebtUserId(858585);
			debtUser.setTekenBookQuantity(10);

			ZoneId defaultZoneId = ZoneId.systemDefault();

			LocalDate localDate = LocalDate.now();

			Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			debtUser.setTakenDate(date);

			CustomerService.takeBook(debtUser);

			DebtUserDetail returningUser = new DebtUserDetail();

			returningUser.setTakenBook("SCIENCE");
			returningUser.setDebtUserId(858585);
			returningUser.setTekenBookQuantity(50);

			String confirmation = null;

			confirmation = CustomerService.returnBook(returningUser);

			assertEquals("YOUR RETURNING TOO MUCH BOOKS,NOT ACCEPTABLE", confirmation);

			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void returningAllBooks() {

		try {
			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();

			BookDetail book1 = new BookDetail();
			book1.setName("SCI");
			book1.setQuantity(20);

			AdminService.uploadBooks(book1);

			BookDetail book2 = new BookDetail();
			book2.setName("MAT");
			book2.setQuantity(20);

			AdminService.uploadBooks(book2);

			DebtUserDetail debtUser = new DebtUserDetail();

			debtUser.setTakenBook("SCI");
			debtUser.setDebtUserId(858585);
			debtUser.setTekenBookQuantity(10);

			ZoneId defaultZoneId = ZoneId.systemDefault();

			LocalDate localDate = LocalDate.now();

			Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			
			debtUser.setTakenDate(date);

			CustomerService.takeBook(debtUser);

			DebtUserDetail returningUser = new DebtUserDetail();

			returningUser.setTakenBook("SCI");
			returningUser.setDebtUserId(858585);
			returningUser.setTekenBookQuantity(10);

			String confirmation = null;

			confirmation = CustomerService.returnBook(returningUser);

			assertEquals("YOU RETURNED ALL BOOKS", confirmation);

			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}
}
