package in.micheal.validator;


import in.micheal.service.*;

import in.micheal.model.*;


public class AdminRegistrationValidator extends ArrayListDataBase {

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