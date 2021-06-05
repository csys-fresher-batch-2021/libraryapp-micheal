package in.micheal.util;

import in.micheal.exception.InValidPasswordException;

public class PasswordValidator {
	private PasswordValidator() {
		// default constructor
	}

	public static void validatePassword(String input) throws InValidPasswordException {
		if (input.length() < 4) {
			throw new InValidPasswordException("TOO WEAK PASSWORD");
		}
	}

	
}
