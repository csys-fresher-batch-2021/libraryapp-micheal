package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.BookDetail;
import in.micheal.service.AdminService;

public class UploadBooksTest {

	@Test
	public void uploadAndUpdateBooks() {
		BookDetail obj = new BookDetail();
		obj.setName("SOCIAL");
		obj.setQuantity(20);
		String msg = AdminService.uploadBooks(obj);
		assertEquals("BOOK UPLOADED SUCCESSFULLY", msg);

		BookDetail obj2 = new BookDetail();
		obj2.setName("SOCIAL");
		obj2.setQuantity(20);
		String msg2 = AdminService.uploadBooks(obj2);
		assertEquals("BOOK UPDATED SUCCESSFULLY", msg2);
	}

}
