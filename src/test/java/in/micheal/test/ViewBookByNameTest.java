package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.BookDetail;
import in.micheal.service.AdminService;
import in.micheal.service.ViewBookByName;

public class ViewBookByNameTest {

	/**
	 * Testing with valid book name,Returned object will not be null
	 */
	@Test
	public void validDetails() {
		BookDetail obj = new BookDetail();
		obj.setName("JAVA");
		obj.setQuantity(20);
		AdminService.uploadBooks(obj);

		obj = ViewBookByName.bookName("JAVA");

		assertNotNull(obj);
	}

	/**
	 * Testing with invalid book name, returned object will be null
	 * 
	 */
	@Test
	public void inValidDetails() {

		BookDetail obj = ViewBookByName.bookName("lol");

		assertNull(obj);

	}

}
