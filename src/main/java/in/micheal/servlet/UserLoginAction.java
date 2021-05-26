package in.micheal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.micheal.exception.DbException;
import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

/**
 * Servlet implementation class UserLoginAction
 */
@WebServlet("/UserLoginAction")
public class UserLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession loggedInUser = request.getSession();
		String redirection = "UserLogin.jsp?msg=";

		try {
			long userId = Long.parseLong(request.getParameter("userId"));
			String password = request.getParameter("password");
			UserDetails user = new UserDetails();
			user.setUserId(userId);
			user.setPassword(password);
			boolean confirmation = false;

			confirmation = UserService.userLogin(user);

			if (confirmation) {
				String msg = "LOGIN SUCCESSFULL";
				RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp?msg=" + msg);
				rd.forward(request, response);
				loggedInUser.setAttribute("LOOGGED_IN_USER", userId);
			} else {
				String msg = "INVALID LOGIN CREDENTIALS";
				RequestDispatcher rd = request.getRequestDispatcher(redirection + msg);
				rd.forward(request, response);
			}
		} catch (DbException | ServletException | IOException e) {
			RequestDispatcher rd = request.getRequestDispatcher(redirection + e.getMessage());
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
