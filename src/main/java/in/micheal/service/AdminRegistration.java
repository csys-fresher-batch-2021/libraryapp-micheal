package in.micheal.service;

import in.micheal.validator.*;
import in.micheal.model.*;

/**
 * This class extends ArrayListDataBase so that it can use userDetails ArrayList 
 * which is present there
 * @author mich2635
 *
 */
public class AdminRegistration extends ArrayListDataBase{  
	
	/**
	 * This method is used to register admin Id in user details
	 * @param adminObj
	 * @return
	 */
	public static String adminRegistration(UserDetails adminObj)
	{
	String confirmation="ADMIN ID ALREADY EXISTS";
	boolean adminIdRepeatation=AdminRegistrationValidator.adminRegistrationValidator(adminObj);
	{
		
		}
		if(!adminIdRepeatation)
		{
			userDetails.add(adminObj);
			confirmation="ADMIN ID ADDED SUCCESSFULLY";
		}
		return confirmation;
	}
	

	
	
}