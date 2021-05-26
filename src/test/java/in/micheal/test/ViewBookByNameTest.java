package in.micheal.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.micheal.dao.BookDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.service.CustomerService;

public class ViewBookByNameTest {

	/**
	 * Testing with valid book name,Returned object will not be null
	 */
	@Test
	public void validDetails() {

		try {
			BookDetailsDAO.deleteAllRecords();

			// First add books
			BookDetail book1 = new BookDetail();
			book1.setName("PYTHON EDITION-3");
			book1.setQuantity(10);

			BookDetail book2 = new BookDetail();
			book2.setName("PYTHON EDITION-1");
			book2.setQuantity(10);

			BookDetail book3 = new BookDetail();
			book2.setName("PYTHON EDITION-2");
			book2.setQuantity(10);

			BookDetailsDAO.addBooks(book1);
			BookDetailsDAO.addBooks(book2);
			BookDetailsDAO.addBooks(book3);

			List<BookDetail> searchResults = null;

			searchResults = CustomerService.getBooks("PYT");

			assertEquals(2, searchResults.size());
			// delete all records

			BookDetailsDAO.deleteAllRecords();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Testing with invalid book name, returned object will be null
	 * 
	 */
	@Test
	public void inValidDetails() {

		List<BookDetail> searchResults = null;

		try {
			searchResults = CustomerService.getBooks("lol");
		} catch (DbException e) {
			e.printStackTrace();
		}

		assertEquals(0, searchResults.size());

	}

}
