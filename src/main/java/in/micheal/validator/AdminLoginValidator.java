package in.micheal.validator;

import in.micheal.model.UserDetails;
import in.micheal.service.AllDetailsDB;

public class AdminLoginValidator {

	public static boolean loginValidator(long adminId, String password) {
		boolean confirmation = false;
		;
		for (UserDetails user : AllDetailsDB.userDetails) {
			if (user.getUserId() == adminId && user.getAdminPassword().equals(password)) {
				confirmation = true;
			}
		}
		return confirmation;
	}

}
