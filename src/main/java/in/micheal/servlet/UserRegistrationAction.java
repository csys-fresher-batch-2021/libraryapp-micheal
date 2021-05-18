package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

/**
 * Servlet implementation class UserRegistrationAction
 */
@WebServlet("/UserRegistrationAction")
public class UserRegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long UserId = Long.parseLong(request.getParameter("userId"));
			String password = request.getParameter("password");
			UserDetails obj = new UserDetails();
			obj.setUserId(UserId);
			obj.setPassword(password);
			boolean confirmation = UserService.userRegistration(obj);
			if (confirmation) {
				String msg = "REGISTRATION SUCCESSFULL";
				response.sendRedirect("UserLogin.jsp?msg=" + msg);
			} else {
				String msg = "USER ID ALREADY EXISTS";
				response.sendRedirect("UserRegistration.jsp?msg=" + msg);
			}

		} catch (Exception e) {
			String msg = e.getMessage();
			response.sendRedirect("UserRegistration.jsp?msg=" + msg);

		}
	}
}
