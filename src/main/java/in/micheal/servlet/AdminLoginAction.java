package in.micheal.servlet;

import java.io.IOException;

import in.micheal.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginAction
 */
@WebServlet("/AdminLoginAction")
public class AdminLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long adminId = Long.parseLong(request.getParameter("adminId"));
		String password = request.getParameter("password");
		boolean confirmation = UserService.adminLogin(adminId, password);
		if (confirmation) {
			response.sendRedirect("AdminView.jsp");
		} else {
			String message = "Invalid Login credentials";
			response.sendRedirect("AdminLogin.jsp?errorMessage=" + message);
		}

	}
}
