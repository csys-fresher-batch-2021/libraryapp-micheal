package in.micheal.model;
/**
 * The information in this class is sensitive so 
 * we used encapsulation
 * @author mich2635
 *
 */
  public class UserDetails {
	private String userName;
	private  long userId;
	private long password;
	private String adminPassword;
	
     
public void setUserName( String Name)
{
	userName=Name;
}
public void setUserId( long ID)
{
	userId=ID;
}
public void setPassword(long userPassword)
{
	password=userPassword;
}
public void setAdminPassword(String adminpasswordS)
{
	adminPassword=adminpasswordS.concat("@chainsys987");
	
}
public String getAdminPassword()
{
	return adminPassword;
}
public String getUserName()
{
	return userName;
}
public long getUserId()
{
	return userId;
}
public long getPassword()
{
	return password;
}
}