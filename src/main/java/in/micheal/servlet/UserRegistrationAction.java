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
 * Servlet implementation class UserRegistrationAction
 */
@WebServlet("/UserRegistrationAction")
public class UserRegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String redirection = "UserRegistration.jsp?msg=";
		try {
			long userId = Long.parseLong(request.getParameter("userId"));
			String password = request.getParameter("password");
			String userName = request.getParameter("userName").toUpperCase();
			Long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
			UserDetails obj = new UserDetails();
			obj.setUserId(userId);
			obj.setPassword(password);
			obj.setUserName(userName);
			obj.setPhoneNo(phoneNo);
			boolean confirmation = UserService.userRegistration(obj);
			if (confirmation) {
				String msg = "REGISTRATION SUCCESSFULL";
				RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp?msg=" + msg);
				rd.forward(request, response);
			} else {
				String msg = "USER ID ALREADY EXISTS";
				RequestDispatcher rd = request.getRequestDispatcher(redirection + msg);
				rd.forward(request, response);
			}

		} catch (DbException | IOException | UserIdException | InValidPasswordException | ServletException e) {
			String msg = e.getMessage();
			try {
				RequestDispatcher rd = request.getRequestDispatcher(redirection + msg);
				rd.forward(request, response);
			} catch (IOException | ServletException e1) {
				e1.printStackTrace();
			}
		}

	}
}
