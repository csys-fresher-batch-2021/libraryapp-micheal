package in.micheal.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import in.micheal.dao.BookDetailsDAO;
import in.micheal.model.BookDetail;
import in.micheal.service.AdminService;

public class ViewBooksTest {

	@Test
	public void test() {
		BookDetail obj = new BookDetail();
		obj.setName("JAVA");
		obj.setQuantity(20);
		AdminService.uploadBooks(obj);

		BookDetail obj2 = new BookDetail();
		obj2.setName("PYTHON");
		obj2.setQuantity(20);
		AdminService.uploadBooks(obj2);

		List<BookDetail> bookDetails = BookDetailsDAO.getBookDetails();
		assertEquals(2, bookDetails.size());
	}

}
