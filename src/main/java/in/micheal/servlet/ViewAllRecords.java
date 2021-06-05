package in.micheal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class ViewAllRecords
 */
@WebServlet("/ViewAllRecords")
public class ViewAllRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<DebtUserDetail> allRecords = new ArrayList<>();

		try {
			allRecords = AdminService.getAllDebtRecords();
			Gson gson = new Gson();
			String json = gson.toJson(allRecords);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (DbException | IOException e) {
			e.printStackTrace();
		}

	}
}
