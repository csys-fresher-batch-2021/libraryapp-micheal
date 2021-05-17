package in.micheal.validator;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.model.UserDetails;

public class UserServiceValidator {
	private UserServiceValidator() {
		// default constructor
	}

	/**
	 * This method validates Admin login credentials
	 * 
	 * @param adminId
	 * @param password
	 * @return
	 */
	public static boolean AdminloginValidator(long adminId, String password) {
		boolean confirmation = false;
		for (UserDetails user : UserDetailsDAO.getUserDetails()) {
			if (user.getUserId() == adminId && user.getAdminPassword().equals(password)) {
				confirmation = true;
				break;
			}
		}
		return confirmation;
	}

	/**
	 * This method validates Admin registration credentials
	 * 
	 * @param adminObj
	 * @return
	 */
	public static boolean adminRegistrationValidator(UserDetails adminObj) {
		boolean registration = false;
		if (adminObj.getUserId() > 1000) {
			for (UserDetails admin : UserDetailsDAO.getUserDetails()) {
				if (admin.getUserId() == adminObj.getUserId()) {
					registration = true;
					break;
				}
			}
		}

		return registration;
	}
}
