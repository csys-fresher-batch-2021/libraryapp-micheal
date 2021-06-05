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
import in.micheal.model.DebtUserDetail;
import in.micheal.service.AdminService;

/**
 * Servlet implementation class ViewFinedUsers
 */
@WebServlet("/ViewFinedUsers")
public class ViewFinedUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<DebtUserDetail> allFinedUser = AdminService.getAllFinedUser();
			Gson gson = new Gson();
			String json = gson.toJson(allFinedUser);
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (DbException | IOException e) {
			e.printStackTrace();
		}

	}
}
