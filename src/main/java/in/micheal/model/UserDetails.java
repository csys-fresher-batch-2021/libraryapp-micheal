package in.micheal.model;

/**
 * The information in this class is sensitive so we used encapsulation
 * 
 * @author mich2635
 *
 */
public class UserDetails {
	private String userName;
	private long userId;
	private String password;
	private String adminPassword;

	public void setUserName(String Name) {
		userName = Name;
	}

	public void setUserId(long ID) {
		userId = ID;
	}

	public void setPassword(String userPassword) {
		password = userPassword;
	}

	public void setAdminPassword(String adminpasswordS) {
		adminPassword = adminpasswordS.concat("@libmanagement987");

	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public String getUserName() {
		return userName;
	}

	public long getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}
}