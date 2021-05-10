package in.micheal.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.micheal.service.*;

import in.micheal.model.*;

public class AdminRegistrationTest {
	/**
	 * Registered id and login id matching
	 * NOTE:password will be encrypted with @chainsys987
	 */
	@Test
	public void registeringAdmin() {
		
		
		//Adding Admin 1
		UserDetails admin1=new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(9629);
		admin1.setAdminPassword("9629");
		String verification = AdminRegistration.adminRegistration(admin1);
		assertEquals("ADMIN ID ADDED SUCCESSFULLY",verification);
		
		
		
	}
	
	/**
	 * Registering with two sameAdmin id
	 */
	@Test
	public void registeringwithTwoSamwUserId() {
		
		
		//Adding Admin 1
		UserDetails admin1=new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(9629);
		admin1.setAdminPassword("9629");
		String verification = AdminRegistration.adminRegistration(admin1);
		assertEquals("ADMIN ID ADDED SUCCESSFULLY",verification);
	
		UserDetails admin2=new UserDetails();
		admin2.setUserName("ADMIN 1");
		admin2.setUserId(9629);
		admin2.setAdminPassword("8870");
		verification = AdminRegistration.adminRegistration(admin1);
		assertEquals("ADMIN ID ALREADY EXISTS",verification);

}
}