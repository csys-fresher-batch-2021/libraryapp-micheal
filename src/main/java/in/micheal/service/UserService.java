package in.micheal.service;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.exception.InValidPasswordException;
import in.micheal.exception.UserIdException;
import in.micheal.model.UserDetails;
import in.micheal.util.PasswordValidator;
import in.micheal.util.UserIdValidator;
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
	 * @throws DbException
	 */
	public static boolean userLogin(UserDetails user) throws DbException {
		boolean confirmation;
		confirmation = UserServiceValidator.userLoginValidator(user.getUserId(), user.getPassword());

		return confirmation;
	}


	/**
	 * This method is used to register users
	 * 
	 * @param userObj
	 * @return
	 * @throws DbException
	 * @throws UserIdException
	 * @throws InValidPasswordException
	 * @throws Throwable
	 * @throws Exception
	 */

	public static boolean userRegistration(UserDetails userObj)
			throws DbException, UserIdException, InValidPasswordException {
		UserIdValidator.validateUserId(userObj.getUserId());
		if (userObj.getAdminPassword() == null) {
			PasswordValidator.validatePassword(userObj.getPassword());
		} else {
			PasswordValidator.validatePassword(userObj.getAdminPassword());
		}

		boolean confirmation = false;
		boolean isRegisteredUser;
		isRegisteredUser = UserServiceValidator.isRegisteredUser(userObj.getUserId());
		if (!isRegisteredUser) {
			if (userObj.getAdminPassword() == null) {
				UserDetailsDAO.addUser(userObj);
			} else {
				UserDetailsDAO.addAdmin(userObj);
			}
			confirmation = true;

		}

		return confirmation;
	}

}
