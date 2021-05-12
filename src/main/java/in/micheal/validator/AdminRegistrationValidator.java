package in.micheal.validator;


import in.micheal.service.*;

import in.micheal.model.*;

/**
 * This methods validate Admin Registration id ,
 * it returns false if admin id already exists
 * @author mich2635
 *
 */
public class AdminRegistrationValidator extends AdminBookDebtuserDob {

	public static boolean adminRegistrationValidator(UserDetails adminObj)
	{
		boolean registration=false;
		if(adminObj.getUserId()>1000)
		{
		for(UserDetails admin:userDetails)
		{
			if(admin.getUserId()==adminObj.getUserId() )
			{
				registration=true;
				break;
			}
	}
		}
		
		return registration;
	}
}