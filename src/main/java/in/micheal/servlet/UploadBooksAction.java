package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.service.AdminService;
import in.micheal.model.BookDetail;

/**
 * Servlet implementation class UploadBooksAction
 */
@WebServlet("/UploadBooksAction")
public class UploadBooksAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName").toUpperCase();
		int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
		BookDetail obj = new BookDetail();
		obj.setName(bookName);
		obj.setQuantity(bookQuantity);
		String confirmationMsg = AdminService.uploadBooks(obj);

		response.sendRedirect("AdminView.jsp?message=" + confirmationMsg);
	}
}
