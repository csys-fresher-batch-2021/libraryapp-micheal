package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.exception.DbException;
import in.micheal.service.CustomerService;

/**
 * Servlet implementation class getFine
 */
@WebServlet("/GetFineAction")
public class GetFineAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			long userId = Long.parseLong(request.getParameter("userid"));
			String bookName = (request.getParameter("bookname")).toUpperCase();

			String fineAmount = CustomerService.calculateFine(userId, bookName).toString();
			RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp?fineamount=" + fineAmount);
			rd.forward(request, response);
		} catch (NumberFormatException | DbException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
