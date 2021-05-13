package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.AdminLogin;
import in.micheal.service.AdminRegistration;

public class AdminLoginTest {

	@Test
	public void validLoginCredentials() {

		// Adding Admin 1
		UserDetails admin1 = new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(4545);
		admin1.setAdminPassword("4545");
		AdminRegistration.adminRegistration(admin1);

		boolean verification = AdminLogin.adminLogin(4545, "4545@libmanagement987");
		assertTrue(verification);
	}

	@Test
	public void invalidCredentials() {

		UserDetails admin2 = new UserDetails();
		admin2.setUserName("ADMIN 2");
		admin2.setUserId(1234);
		admin2.setAdminPassword("1234");
		AdminRegistration.adminRegistration(admin2);

		boolean verification = AdminLogin.adminLogin(7878, "7878@libmanagement987");
		assertFalse(verification);
	}
}
