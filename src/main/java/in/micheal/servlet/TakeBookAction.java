package in.micheal.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.service.CustomerService;

/**
 * Servlet implementation class TakeBookAction
 */
@WebServlet("/TakeBookAction")
public class TakeBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession loggedInUser = request.getSession();
		long loggedInUsername = (long) loggedInUser.getAttribute("LOOGGED_IN_USER");
		String bookName = request.getParameter("bookName").toUpperCase();
		int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
		BookDetail book = new BookDetail();
		book.setName(bookName);
		book.setQuantity(bookQuantity);
		DebtUserDetail debtUser = new DebtUserDetail();
		debtUser.setDebtUserId(loggedInUsername);
		debtUser.setTakenBook(bookName);
		debtUser.setTekenBookQuantity(bookQuantity);
		debtUser.setTakenDate(null);
		LocalDate date = LocalDate.now();
		debtUser.setTakenDate(date);
		String confirmation = CustomerService.takeBook(book, debtUser);
		response.sendRedirect("UserView.jsp?msg=" + confirmation);

	}

}
