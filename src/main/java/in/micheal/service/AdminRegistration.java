package in.micheal.service;

import in.micheal.validator.AdminRegistrationValidator;
import in.micheal.model.*;

/**
 * This class extends ArrayListDataBase so that it can use userDetails ArrayList
 * which is present there
 * 
 * @author mich2635
 *
 */
public class AdminRegistration {

	private AdminRegistration() {
		// default constructor
	}

	/**
	 * This method is used to register admin Id in user details
	 * 
	 * @param adminObj
	 * @return
	 */
	public static boolean adminRegistration(UserDetails adminObj) {
		boolean confirmation = false;
		boolean adminIdRepeatation = AdminRegistrationValidator.adminRegistrationValidator(adminObj);

		if (!adminIdRepeatation) {
			AllDetailsDB.userDetails.add(adminObj);
			confirmation = true;
		}
		return confirmation;
	}

}