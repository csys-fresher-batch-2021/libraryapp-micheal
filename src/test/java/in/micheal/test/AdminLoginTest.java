package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.AdminLogin;
import in.micheal.service.AdminRegistration;

public class AdminLoginTest {

	@Test
	public void ValidCredentials() {

		// Adding Admin 1
		UserDetails admin1 = new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(9629);
		admin1.setAdminPassword("9629");
		AdminRegistration.adminRegistration(admin1);
		boolean verification = AdminLogin.adminLogin(9629, "9629@libmanagement987");
		assertTrue(verification);

	}

	@Test
	public void InvalidCredentials() {

		// Adding Admin 1
		UserDetails admin2 = new UserDetails();
		admin2.setUserName("ADMIN 2");
		admin2.setUserId(8870);
		admin2.setAdminPassword("8870");
		AdminRegistration.adminRegistration(admin2);
		boolean verification = AdminLogin.adminLogin(12345, "9629@libmanagement987");
		assertFalse(verification);

	}

}
