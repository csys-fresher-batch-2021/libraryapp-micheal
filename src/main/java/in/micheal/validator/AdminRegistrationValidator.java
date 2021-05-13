package in.micheal.validator;

import in.micheal.model.UserDetails;
import in.micheal.service.AllDetailsDB;

/**
 * This methods validate Admin Registration id , it returns false if admin id
 * already exists
 * 
 * @author mich2635
 *
 */
public class AdminRegistrationValidator {

	public static boolean adminRegistrationValidator(UserDetails adminObj) {
		boolean registration = false;
		if (adminObj.getUserId() > 1000) {
			for (UserDetails admin : AllDetailsDB.userDetails) {
				if (admin.getUserId() == adminObj.getUserId()) {
					registration = true;
					break;
				}
			}
		}

		return registration;
	}
}