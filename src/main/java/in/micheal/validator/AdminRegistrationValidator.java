package in.micheal.validator;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.model.UserDetails;

/**
 * This methods validate Admin Registration id , it returns false if admin id
 * already exists
 * 
 * @author mich2635
 *
 */
public class AdminRegistrationValidator {

	private AdminRegistrationValidator() {
		// default constructor
	}

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