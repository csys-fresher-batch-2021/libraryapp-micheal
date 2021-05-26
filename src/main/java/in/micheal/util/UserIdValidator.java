package in.micheal.util;

import in.micheal.exception.UserIdException;

public class UserIdValidator {
	private UserIdValidator() {
		// default constructor
	}
	public static void validateUserId(long userId) throws UserIdException {
		if(userId <1000) {
			throw new UserIdException("INVALID USER ID");
	}
	}

}
