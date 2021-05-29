package in.micheal.servlet;

import java.io.IOException;

import in.micheal.exception.DbException;
import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

import javax.servlet.RequestDispatcher;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String message;
		try {
			long adminId = Long.parseLong(request.getParameter("adminId"));
			String password = request.getParameter("password");

			UserDetails admin = new UserDetails();
			admin.setUserId(adminId);
			admin.setPassword(password);
			boolean confirmation;

			confirmation = UserService.userLogin(admin);

			if (confirmation) {
				RequestDispatcher rd = request.getRequestDispatcher("AdminView.jsp");
				rd.forward(request, response);
			} else {
				message = "Invalid Login credentials";
				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp?errorMessage=" + message);
				rd.forward(request, response);
			}
		} catch (DbException | ServletException | IOException e) {
			message = e.getMessage();
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp?errorMessage=" + message);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}

		}

	}
}
