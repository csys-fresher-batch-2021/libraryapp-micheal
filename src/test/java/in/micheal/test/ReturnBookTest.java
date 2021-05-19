package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.service.AdminService;
import in.micheal.service.TakeOrReturnBook;

public class ReturnBookTest {

	@Test
	public void returningSomeBooks() {

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

		DebtUserDetail debtUser = new DebtUserDetail();
		debtUser.setDebtUserId(962950);
		debtUser.setTakenBook("MATHS");
		debtUser.setTekenBookQuantity(10);

		TakeOrReturnBook.takeBook(takingBook, debtUser);

		BookDetail returningBook = new BookDetail();
		returningBook.setName("MATHS");
		returningBook.setQuantity(5);

		String confirmation = TakeOrReturnBook.returnBook(returningBook, debtUser);
		assertEquals("YOU RETURNED SOME BOOKS", confirmation);
	}

	@Test
	public void returningManyBooks() {

		BookDetail book1 = new BookDetail();
		book1.setName("SCIENCE");
		book1.setQuantity(20);
		AdminService.uploadBooks(book1);

		BookDetail book2 = new BookDetail();
		book2.setName("MATHS");
		book2.setQuantity(20);
		AdminService.uploadBooks(book2);

		BookDetail takingBook = new BookDetail();
		takingBook.setName("SCIENCE");
		takingBook.setQuantity(10);

		DebtUserDetail debtUser = new DebtUserDetail();
		debtUser.setDebtUserId(962950);
		debtUser.setTakenBook("SCIENCE");
		debtUser.setTekenBookQuantity(10);

		TakeOrReturnBook.takeBook(takingBook, debtUser);

		BookDetail returningBook = new BookDetail();
		returningBook.setName("SCIENCE");
		returningBook.setQuantity(15);

		String confirmation = TakeOrReturnBook.returnBook(returningBook, debtUser);
		assertEquals("YOUR RETURNING TOO MUCH BOOKS", confirmation);
	}

	@Test
	public void returningAllBooks() {

		BookDetail book1 = new BookDetail();
		book1.setName("SCIENCE");
		book1.setQuantity(20);
		AdminService.uploadBooks(book1);

		BookDetail book2 = new BookDetail();
		book2.setName("MATHS");
		book2.setQuantity(20);
		AdminService.uploadBooks(book2);

		BookDetail takingBook = new BookDetail();
		takingBook.setName("SCIENCE");
		takingBook.setQuantity(10);

		DebtUserDetail debtUser = new DebtUserDetail();
		debtUser.setDebtUserId(962950);
		debtUser.setTakenBook("SCIENCE");
		debtUser.setTekenBookQuantity(10);

		TakeOrReturnBook.takeBook(takingBook, debtUser);

		BookDetail returningBook = new BookDetail();
		returningBook.setName("SCIENCE");
		returningBook.setQuantity(10);

		String confirmation = TakeOrReturnBook.returnBook(returningBook, debtUser);
		assertEquals("YOU RETURNED ALL BOOKS", confirmation);
	}

}
