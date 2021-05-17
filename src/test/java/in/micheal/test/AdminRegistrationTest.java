package in.micheal.test;

import in.micheal.service.UserService;
import in.micheal.model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdminRegistrationTest {
	/**
	 * Registered id and login id matching NOTE:password will be encrypted
	 * with @chainsys987
	 */
	@Test
	public void registeringAdmin() {

		// Adding Admin 1
		UserDetails admin1 = new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(9629);
		admin1.setAdminPassword("9629");
		boolean verification = UserService.adminRegistration(admin1);
		assertTrue(verification);

	}

	/**
	 * Registering with two sameAdmin id
	 */
	@Test
	public void registeringwithTwoSameUserId() {

		// Adding Admin 1
		UserDetails admin1 = new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(8870);
		admin1.setAdminPassword("8870");
		boolean verification = UserService.adminRegistration(admin1);
		assertTrue(verification);

		UserDetails admin2 = new UserDetails();
		admin2.setUserName("ADMIN 1");
		admin2.setUserId(8870);
		admin2.setAdminPassword("8870");
		verification = UserService.adminRegistration(admin1);
		assertFalse(verification);

	}
}