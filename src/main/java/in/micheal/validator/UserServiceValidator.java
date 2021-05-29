package in.micheal.validator;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.exception.DbException;

public class UserServiceValidator {
	private UserServiceValidator() {
		// default constructor
	}

	/**
	 * This method validates Admin registration credentials
	 * 
	 * @param adminObj
	 * @return
	 * @throws DbException
	 */
	public static boolean isRegisteredUser(Long userid) throws DbException {
		boolean registeredUser = false;
		Long userId;
		userId = UserDetailsDAO.findUser(userid);
		if (userId != null) {
			registeredUser = true;
		}

		return registeredUser;
	}

	/**
	 * This method validates user Login credentials
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws DbException
	 */
	public static boolean userLoginValidator(long userId, String password) throws DbException {
		boolean confirmation = false;
		Long userid = null;

		userid = UserDetailsDAO.getUserIdAndPassword(userId, password);

		if (userid != null) {
			confirmation = true;
		}
		return confirmation;
	}
}
