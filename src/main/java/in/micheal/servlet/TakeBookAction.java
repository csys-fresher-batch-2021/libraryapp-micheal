package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.controller.Controller;
import in.micheal.exception.DbException;

/**
 * Servlet implementation class TakeBookAction
 */
@WebServlet("/TakeBookAction")
public class TakeBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession loggedInUser = request.getSession();
		long loggedInUsername = (long) loggedInUser.getAttribute("LOGGED_IN_USER");
		String bookName = request.getParameter("bookName").toUpperCase();
		String confirmation;
		try {
			int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));

			confirmation = Controller.takeBookController(bookName, bookQuantity, loggedInUsername);

			RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp?msg=" + confirmation);
			rd.forward(request, response);
		} catch (DbException | ServletException | IOException e) {
			confirmation = e.getMessage();
			RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp?msg=" + confirmation);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
