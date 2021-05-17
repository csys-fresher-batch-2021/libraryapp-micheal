package in.micheal.dao;

import java.util.ArrayList;
import java.util.List;

import in.micheal.model.UserDetails;

public class UserDetailsDAO {

	public static final List<UserDetails> userDetails = new ArrayList<UserDetails>();

	public static List<UserDetails> getUserDetails() {
		return userDetails;
	}

	/**
	 * This method is used to add users to userDetails
	 * 
	 * @param userObj
	 */
	public static void addUser(UserDetails userObj) {
		userDetails.add(userObj);
	}
}
