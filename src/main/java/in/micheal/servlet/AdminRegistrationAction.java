package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.micheal.model.UserDetails;
import in.micheal.service.AdminRegistration;

/**
 * Servlet implementation class AdminRegistrationAction
 */
@WebServlet("/AdminRegistrationAction")
public class AdminRegistrationAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long adminId = Long.parseLong(request.getParameter("adminId"));
		String password = request.getParameter("adminPassword");

		UserDetails admin = new UserDetails();
		admin.setUserId(adminId);
		admin.setAdminPassword(password);

		boolean confirmation = AdminRegistration.adminRegistration(admin);

		if (confirmation) {
			String message = "ADMIN ID ADDED SUCCESSFULLY";
			response.sendRedirect("AdminLogin.jsp?infoMessage=" + message);
		} else {
			String message = "ADMIN ID ALREADY EXISTS";
			response.sendRedirect("AdminRegistration.jsp?errorMessage=" + message);
		}
	}
}