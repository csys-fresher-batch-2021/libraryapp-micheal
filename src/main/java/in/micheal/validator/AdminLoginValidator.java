package in.micheal.validator;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.model.UserDetails;

public class AdminLoginValidator {

	private AdminLoginValidator() {
		// default constructor
	}

	public static boolean loginValidator(long adminId, String password) {
		boolean confirmation = false;
		for (UserDetails user : UserDetailsDAO.getUserDetails()) {
			if (user.getUserId() == adminId && user.getAdminPassword().equals(password)) {
				confirmation = true;
				break;
			}
		}
		return confirmation;
	}

}