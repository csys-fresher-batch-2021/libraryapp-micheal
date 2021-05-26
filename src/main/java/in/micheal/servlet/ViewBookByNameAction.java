package in.micheal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.micheal.exception.DbException;
import in.micheal.model.BookDetail;
import in.micheal.service.CustomerService;

/**
 * Servlet implementation class ViewBookByNameAction
 */
@WebServlet("/ViewBookByNameAction")
public class ViewBookByNameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<BookDetail> searchResults = null;
		try {
			searchResults = CustomerService.getBooks(request.getParameter("bookName").toUpperCase());
			Gson gson = new Gson();
			String json = gson.toJson(searchResults);
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();

		} catch (DbException | IOException e) {
			e.printStackTrace();
		}

	}
}
