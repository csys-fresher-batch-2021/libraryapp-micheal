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
	private long phoneNo;

	public void setUserName(String name) {
		userName = name;
	}

	public void setUserId(long id) {
		userId = id;
	}

	public void setPassword(String userPassword) {
		password = userPassword;
	}

	public void setAdminPassword(String adminpasswordS) {
		adminPassword = adminpasswordS.concat("@lib_987");

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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}