package in.micheal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		long userId = Long.parseLong(request.getParameter("userId"));
		String password = request.getParameter("password");
		System.out.println(userId);
		System.out.println(password);
		boolean confirmation = UserService.UserLogin(userId, password);
		if (confirmation) {
			String msg = "LOGIN SUCCESSFULL";
			response.sendRedirect("UserView.jsp?msg=" + msg);
		} else {
			String msg = "INVALID LOGIN CREDENTIALS";
			response.sendRedirect("UserLogin.jsp?msg=" + msg);
		}
	}

}
