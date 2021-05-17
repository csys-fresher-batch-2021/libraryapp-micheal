package in.micheal.dao;

import java.util.ArrayList;
import java.util.List;

import in.micheal.model.UserDetails;

public class UserDetailsDAO {
	private UserDetailsDAO() {
		// default constructor
	}

	private static final List<UserDetails> userDetails = new ArrayList<>();

	public static List<UserDetails> getUserDetails() {
		return userDetails;
	}

	/**
	 * This method is used to add users
	 * 
	 * @param userObj
	 */
	public static void addUser(UserDetails userObj) {
		userDetails.add(userObj);
	}
}
