package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.exception.DbException;
import in.micheal.exception.InValidPasswordException;
import in.micheal.exception.UserIdException;
import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

/**
 * Servlet implementation class AdminRegistrationAction
 */
@WebServlet("/AdminRegistrationAction")
public class AdminRegistrationAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			long adminId = Long.parseLong(request.getParameter("adminId"));
			String password = request.getParameter("adminPassword");
			Long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
			String name = request.getParameter("adminName");

			UserDetails admin = new UserDetails();
			admin.setUserId(adminId);
			admin.setAdminPassword(password);
			admin.setPhoneNo(phoneNo);
			admin.setUserName(name);

			boolean confirmation = UserService.userRegistration(admin);

			if (confirmation) {
				String message = "ADMIN ID ADDED SUCCESSFULLY";
				response.sendRedirect("AdminLogin.jsp?infoMessage=" + message);
			} else {
				String message = "ADMIN ID ALREADY EXISTS";
				RequestDispatcher rd = request.getRequestDispatcher("AdminRegistration.jsp?errorMessage=" + message);
				rd.forward(request, response);
			}
		} catch (DbException | IOException | UserIdException | InValidPasswordException | ServletException e) {
			String message = e.getMessage();

			RequestDispatcher rd = request.getRequestDispatcher("AdminRegistration.jsp?errorMessage=" + message);

			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
