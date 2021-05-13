package in.micheal.service;

import in.micheal.validator.AdminLoginValidator;

public class AdminLoginJ {
	private AdminLoginJ() {
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
		boolean confirmation = AdminLoginValidator.loginValidator(adminId, password);
		if (confirmation) {
			verification = true;
		}
		return verification;

	}
}
