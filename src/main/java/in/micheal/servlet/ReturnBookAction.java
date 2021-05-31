package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.model.DebtUserDetail;
import in.micheal.service.CustomerService;

/**
 * Servlet implementation class ReturnBookAction
 */
@WebServlet("/ReturnBookAction")
public class ReturnBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession loggedInUser = request.getSession();
		long loggedInUsername = (long) loggedInUser.getAttribute("LOGGED_IN_USER");

		BookDetail book = new BookDetail();
		DebtUserDetail debtUser = new DebtUserDetail();

		String bookName = request.getParameter("bookName").toUpperCase();
		int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));

		book.setName(bookName);
		book.setQuantity(bookQuantity);

		debtUser.setDebtUserId(loggedInUsername);
		debtUser.setTakenBook(bookName);
		debtUser.setTekenBookQuantity(bookQuantity);

		String confirmation = null;
		try {
			confirmation = CustomerService.returnBook(debtUser);
		} catch (DbException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp?msg=" + confirmation);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
