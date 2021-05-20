package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.BookDetail;
import in.micheal.service.AdminService;
import in.micheal.service.CustomerService;

public class TakeBookTest {

	@Test
	public void validBookNameAndQuantity() {

		BookDetail book1 = new BookDetail();
		book1.setName("SCIENCE");
		book1.setQuantity(20);
		AdminService.uploadBooks(book1);

		BookDetail book2 = new BookDetail();
		book2.setName("MATHS");
		book2.setQuantity(20);
		AdminService.uploadBooks(book2);

		BookDetail takingBook = new BookDetail();
		takingBook.setName("MATHS");
		takingBook.setQuantity(10);

		String confirmation = CustomerService.takeBook(takingBook, null);
		assertEquals("BOOK TAKEN SUCCESSFULLY", confirmation);

	}

	@Test
	public void inValidBookName() {

		BookDetail book1 = new BookDetail();
		book1.setName("SCIENCE");
		book1.setQuantity(20);
		AdminService.uploadBooks(book1);

		BookDetail book2 = new BookDetail();
		book2.setName("MATHS");
		book2.setQuantity(20);
		AdminService.uploadBooks(book2);

		BookDetail takingBook = new BookDetail();
		takingBook.setName("lol");
		takingBook.setQuantity(10);

		String confirmation = CustomerService.takeBook(takingBook, null);
		assertEquals("SORRY BOOK NOT AVAILABLE", confirmation);
	}

	@Test
	public void moreThanAvailabaleQuantityCheck() {
		BookDetail book1 = new BookDetail();
		book1.setName("SCIENCE");
		book1.setQuantity(20);
		AdminService.uploadBooks(book1);

		BookDetail book2 = new BookDetail();
		book2.setName("MATHS");
		book2.setQuantity(20);
		AdminService.uploadBooks(book2);

		BookDetail takingBook = new BookDetail();
		takingBook.setName("MATHS");
		takingBook.setQuantity(200);

		String confirmation = CustomerService.takeBook(takingBook, null);
		assertEquals("SORRY INSUFFICIENT BOOK", confirmation);
	}
}
