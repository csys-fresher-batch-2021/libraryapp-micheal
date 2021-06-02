package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.exception.DbException;
import in.micheal.service.AdminService;

/**
 * Servlet implementation class PayFineAction
 */
@WebServlet("/PayFineAction")
public class PayFineAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			long userId = Long.parseLong(request.getParameter("userid"));
			String bookName = request.getParameter("bookname");
			AdminService.payFine(userId, bookName);
			String fineMsg = "RENEWED SUCCESSFULLY";
			RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp?fineMsg=" + fineMsg);
			rd.forward(request, response);
		} catch (NumberFormatException | DbException | ServletException | IOException e) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp?errorMsg=" + e.getMessage());
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}