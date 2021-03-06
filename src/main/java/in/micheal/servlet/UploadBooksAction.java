package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.controller.Controller;
import in.micheal.exception.DbException;

/**
 * Servlet implementation class UploadBooksAction
 */
@WebServlet("/UploadBooksAction")
public class UploadBooksAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String bookName = request.getParameter("bookName").toUpperCase();
		try {
			int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));

			String confirmation = Controller.uploadBooksController(bookName, bookQuantity);
			RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp?msg=" + confirmation);
			rd.forward(request, response);
		} catch (DbException | ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
