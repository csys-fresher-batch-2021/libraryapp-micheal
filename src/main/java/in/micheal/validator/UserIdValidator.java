package in.micheal.validator;

import in.micheal.exception.UserIdException;

public class UserIdValidator {
	private UserIdValidator() {
		// default constructor
	}
	public static void validateUserId(long userId) throws Throwable {
		if(userId <1000) {
			throw new UserIdException("INVALID USER ID");
	}
	}

}
