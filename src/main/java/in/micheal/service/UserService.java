package in.micheal.service;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.model.UserDetails;
import in.micheal.validator.UserServiceValidator;

public class UserService {
	private UserService() {
		// default constructor
	}

	/**
	 * This methods return true if the log in credentials is true
	 * 
	 * @param adminId
	 * @param password
	 * @return
	 */
	public static boolean adminLogin(long adminId, String password) {
		boolean verification = false;
		boolean confirmation = UserServiceValidator.AdminloginValidator(adminId, password);
		if (confirmation) {
			verification = true;
		}
		return verification;

	}

	/**
	 * This method is used to register admin Id in user details
	 * 
	 * @param adminObj
	 * @return
	 */
	public static boolean adminRegistration(UserDetails adminObj) {
		boolean confirmation = false;
		boolean adminIdRepeatation = UserServiceValidator.adminRegistrationValidator(adminObj);

		if (!adminIdRepeatation) {
			UserDetailsDAO.addUser(adminObj);
			confirmation = true;
		}
		return confirmation;
	}

}