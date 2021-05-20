package in.micheal.validator;

import in.micheal.exception.InValidPasswordException;

public class PasswordValidator {
	private PasswordValidator() {
		// default constructor
	}

	public static void validatePassword(String input) throws InValidPasswordException {
		if (input.length() < 4) {
			throw new InValidPasswordException("PASSWORD LENGTH MUST BE GREATER THAN 4 DIGITS");
		}
	}
}
