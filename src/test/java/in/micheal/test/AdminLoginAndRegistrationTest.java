package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.exception.InValidPasswordException;
import in.micheal.exception.UserIdException;
import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

public class AdminLoginAndRegistrationTest {

	@Test
	public void validCredentials() throws DbException, UserIdException, InValidPasswordException {

		
			UserDetailsDAO.deleteAllRecords();
			

			UserDetails admin1 = new UserDetails();
			admin1.setUserName("ADMIN 1");
			admin1.setUserId(454545);
			admin1.setAdminPassword("454545");
			boolean confirmation = false;

			UserService.userRegistration(admin1);
			confirmation = UserService.adminLogin(admin1);

			assertTrue(confirmation);

			// delete all records

			UserDetailsDAO.deleteAllRecords();
		

	}

	@Test
	public void invalidCredentials() throws DbException {

		
			UserDetailsDAO.deleteAllRecords();

			UserDetails admin = new UserDetails();
			admin.setUserName("ADMIN 1");
			admin.setUserId(4545445);
			admin.setAdminPassword("454545");

			boolean verification = true;

			verification = UserService.adminLogin(admin);

			assertFalse(verification);

			UserDetailsDAO.deleteAllRecords();
		

	}

	@Test
	public void smallerUserIdRegistrationCheck() throws DbException {

		
			// Delete all records

			UserDetailsDAO.deleteAllRecords();
			try {
			UserDetails admin = new UserDetails();
			admin.setUserName("ADMIN 1");
			admin.setUserId(454);
			admin.setAdminPassword("454545");

			UserService.userRegistration(admin);
			} catch (DbException | UserIdException | InValidPasswordException e) {
				assertEquals("INVALID USER ID", e.getMessage());
			}

			// Delete all records

			UserDetailsDAO.deleteAllRecords();
		

	}

	@Test
	public void smallerPasswordCheck() throws DbException {

		

			UserDetailsDAO.deleteAllRecords();
			try {
			UserDetails admin = new UserDetails();
			admin.setUserName("ADMIN 1");
			admin.setUserId(454454);
			admin.setAdminPassword("454");

			UserService.userRegistration(admin);
			} catch (DbException | UserIdException | InValidPasswordException e) {
				assertEquals("TOO WEAK PASSWORD", e.getMessage());
			}


			UserDetailsDAO.deleteAllRecords();
		

	}
}
