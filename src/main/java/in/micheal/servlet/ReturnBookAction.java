package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.service.TakeOrReturnBook;

/**
 * Servlet implementation class ReturnBookAction
 */
@WebServlet("/ReturnBookAction")
public class ReturnBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession loggedInUser = request.getSession();
		long loggedInUsername = (long) loggedInUser.getAttribute("LOOGGED_IN_USER");

		BookDetail book = new BookDetail();
		DebtUserDetail debtUser = new DebtUserDetail();

		String bookName = request.getParameter("bookName");
		int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));

		book.setName(bookName);
		book.setQuantity(bookQuantity);

		debtUser.setDebtUserId(loggedInUsername);
		debtUser.setTakenBook(bookName);
		debtUser.setTekenBookQuantity(bookQuantity);

		String confirmation = TakeOrReturnBook.returnBook(book, debtUser);
		response.sendRedirect("UserView.jsp?msg=" + confirmation);
	}

}
