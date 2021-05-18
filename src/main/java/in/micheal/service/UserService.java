package in.micheal.service;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.model.UserDetails;
import in.micheal.util.StringValidator;
import in.micheal.validator.UserServiceValidator;

public class UserService {
	private UserService() {
		// default constructor
	}

	/**
	 * This method returns true if the login credentials is true or else false
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public static boolean UserLogin(long userId, String password) {
		boolean verification = false;
		boolean confirmation = UserServiceValidator.userLoginValidator(userId, password);
		if (confirmation) {
			verification = true;
		}
		return verification;
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
		boolean confirmation = UserServiceValidator.adminloginValidator(adminId, password);
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
		boolean adminIdRepeatation = UserServiceValidator.registrationValidator(adminObj);

		if (!adminIdRepeatation) {
			UserDetailsDAO.addUser(adminObj);
			confirmation = true;
		}
		return confirmation;
	}

	/**
	 * This method is used to register users
	 * 
	 * @param userObj
	 * @return
	 * @throws Exception
	 */

	public static boolean userRegistration(UserDetails userObj) {
		boolean confirmation = false;
		StringValidator.lengthvalidator(userObj.getPassword());
		boolean userIdRepetation = UserServiceValidator.registrationValidator(userObj);
		if (!userIdRepetation) {
			UserDetailsDAO.addUser(userObj);
			confirmation = true;
		}
		return confirmation;

	}
}
