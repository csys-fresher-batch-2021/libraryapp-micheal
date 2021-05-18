package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.BookDetail;
import in.micheal.service.ViewBookByName;

public class ViewBookByNameTest {

	/**
	 * Testing with valid book name,Returned object will not be null
	 */
	@Test
	public void validDetails() {
		BookDetail obj = null;

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
