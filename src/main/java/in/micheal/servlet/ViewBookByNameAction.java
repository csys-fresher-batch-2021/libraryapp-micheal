package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.model.BookDetail;
import in.micheal.service.ViewBookByName;

/**
 * Servlet implementation class ViewBookByNameAction
 */
@WebServlet("/ViewBookByNameAction")
public class ViewBookByNameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDetail obj = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		obj = ViewBookByName.bookName(request.getParameter("bookName"));

		if (obj != null) {
			int bookQuantity = obj.getQuantity();
			response.sendRedirect("ViewBooks.jsp?bookQuantity=" + bookQuantity);
		} else {
			response.sendRedirect("ViewBooks.jsp?bookQuantity=" + "0");

		}
	}
}
