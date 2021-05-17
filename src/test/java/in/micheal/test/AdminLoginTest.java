package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

public class AdminLoginTest {

	@Test
	public void validCredentials() {

		// Adding Admin 1
		UserDetails admin1 = new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(4545);
		admin1.setAdminPassword("4545");
		UserService.adminRegistration(admin1);
		boolean verification = UserService.adminLogin(4545, "4545@libmanagement987");
		assertTrue(verification);

	}

	@Test
	public void invalidCredentials() {

		// Adding Admin 1
		UserDetails admin2 = new UserDetails();
		admin2.setUserName("ADMIN 2");
		admin2.setUserId(4646);
		admin2.setAdminPassword("4646");
		UserService.adminRegistration(admin2);
		boolean verification = UserService.adminLogin(12345, "9629@libmanagement987");
		assertFalse(verification);

	}

}
