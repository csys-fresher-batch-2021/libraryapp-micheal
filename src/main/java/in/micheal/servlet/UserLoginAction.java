package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.service.UserService;

/**
 * Servlet implementation class UserLoginAction
 */
@WebServlet("/UserLoginAction")
public class UserLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession loggedInUser = request.getSession();

		long userId = Long.parseLong(request.getParameter("userId"));
		String password = request.getParameter("password");
		boolean confirmation = UserService.userLogin(userId, password);
		if (confirmation) {
			String msg = "LOGIN SUCCESSFULL";
			response.sendRedirect("UserView.jsp?msg=" + msg);
			loggedInUser.setAttribute("LOOGGED_IN_USER", userId);
		} else {
			String msg = "INVALID LOGIN CREDENTIALS";
			response.sendRedirect("UserLogin.jsp?msg=" + msg);
		}
	}

}
