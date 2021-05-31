package in.micheal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.service.CustomerService;

/**
 * Servlet implementation class TakeBookButtonAction
 */
@WebServlet("/TakeOrReturnBookButtonAction")
public class TakeOrReturnBookButtonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession loggedInUser = request.getSession();
		Long loggedInUsername = (Long) loggedInUser.getAttribute("LOGGED_IN_USER");

		String verification = request.getParameter("takeorreturnbook");

		if (verification.equals("returnBook")) {
			try {
				List<BookDetail> debtUserBooks = CustomerService.getBooks(loggedInUsername);
				request.setAttribute("debtUserBooks", debtUserBooks);
				RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp?verification=" + verification);
				rd.forward(request, response);

			} catch (DbException | ServletException | IOException e) {

				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp?verification=" + verification);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
