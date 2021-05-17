package in.micheal.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import in.micheal.dao.BookDetailsDAO;
import in.micheal.model.BookDetails;

public class ViewBooksTest {

	@Test
	public void test() {
		List<BookDetails> bookDetails = BookDetailsDAO.getBookDetails();
		assertEquals(2, bookDetails.size());
	}

}
