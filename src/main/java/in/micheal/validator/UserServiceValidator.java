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
	public static boolean adminloginValidator(long adminId, String password) {
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
	public static boolean registrationValidator(UserDetails obj) {
		boolean registration = false;
		if (obj.getUserId() > 1000) {
			for (UserDetails objV : UserDetailsDAO.getUserDetails()) {
				if (objV.getUserId() == obj.getUserId()) {
					registration = true;
					break;
				}
			}
		}

		return registration;
	}

	/**
	 * This method validates user Login credentials
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public static boolean userLoginValidator(long userId, String password) {
		boolean confirmation = false;
		for (UserDetails user : UserDetailsDAO.getUserDetails()) {
			if (user.getUserId() == userId && user.getPassword().equals(password)) {
				confirmation = true;
				break;
			}
		}
		return confirmation;
	}
}
