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

public class TakeBookTest {

	@Test
	public void validBookNameAndQuantity() {
		String verification = null;

		try {
			BookDetailsDAO.deleteAllRecords();


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

			verification = CustomerService.takeBook(debtUser);

			assertEquals("BOOK TAKEN SUCCESSFULLY", verification);

			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void inValidBookName() {

		String confirmation = null;

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

			DebtUserDetail debtUser = new DebtUserDetail();

			debtUser.setTakenBook("lol");
			debtUser.setDebtUserId(858585);
			debtUser.setTekenBookQuantity(10);

			ZoneId defaultZoneId = ZoneId.systemDefault();

			LocalDate localDate = LocalDate.now();

			Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			debtUser.setTakenDate(date);

			confirmation = CustomerService.takeBook(debtUser);

			assertEquals("SORRY INSUFFICIENT BOOK", confirmation);

			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void moreThanAvailableQuantityCheck() {

		try {
			BookDetailsDAO.deleteAllRecords();

			DebtUserDetailsDAO.deleteAllRecords();

			String confirmation = null;
			BookDetail book1 = new BookDetail();
			book1.setName("SCIENCE");
			book1.setQuantity(20);

			AdminService.uploadBooks(book1);

			BookDetail book2 = new BookDetail();
			book2.setName("MATHS");
			book2.setQuantity(20);

			AdminService.uploadBooks(book2);

			DebtUserDetail debtUser = new DebtUserDetail();

			debtUser.setTakenBook("MATHS");
			debtUser.setDebtUserId(858585);
			debtUser.setTekenBookQuantity(50);

			ZoneId defaultZoneId = ZoneId.systemDefault();

			LocalDate localDate = LocalDate.now();

			Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
			debtUser.setTakenDate(date);

			confirmation = CustomerService.takeBook(debtUser);

			assertEquals("SORRY INSUFFICIENT BOOK", confirmation);

			DebtUserDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

}
