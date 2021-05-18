package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.BookDetail;
import in.micheal.service.AdminService;

public class UploadBooksTest {

	@Test
	public void uploadAndUpdateBooks() {
		BookDetail obj = new BookDetail();
		obj.setName("SCIENCE");
		obj.setQuantity(20);
		String msg = AdminService.uploadBooks(obj);
		System.out.println(msg);
		assertEquals("BOOK UPLOADED SUCCESSFULLY", msg);

		BookDetail obj2 = new BookDetail();
		obj2.setName("SCIENCE");
		obj2.setQuantity(20);
		String msg2 = AdminService.uploadBooks(obj2);
		System.out.println(msg2);
		assertEquals("BOOK UPDATED SUCCESSFULLY", msg2);
	}

}
