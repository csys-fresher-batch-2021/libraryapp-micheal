package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.AdminLoginJ;
import in.micheal.service.AdminRegistration;

public class AdminLoginTest {

	@Test
	public void validLoginCredentials() {

		// Adding Admin 1
		UserDetails admin1 = new UserDetails();
		admin1.setUserName("ADMIN 1");
		admin1.setUserId(9629);
		admin1.setAdminPassword("9629");
		AdminRegistration.adminRegistration(admin1);

		boolean verification = AdminLoginJ.adminLogin(9629, "9629@libmanagement987");
		assertTrue(verification);
	}

	@Test
	public void invalidCredentials() {

		UserDetails admin2 = new UserDetails();
		admin2.setUserName("ADMIN 2");
		admin2.setUserId(8870);
		admin2.setAdminPassword("8870");
		AdminRegistration.adminRegistration(admin2);

		boolean verification = AdminLoginJ.adminLogin(7878, "9629@libmanagement987");
		assertFalse(verification);
	}
}
