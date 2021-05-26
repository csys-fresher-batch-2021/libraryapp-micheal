package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.dao.UserDetailsDAO;
import in.micheal.exception.DbException;
import in.micheal.exception.InValidPasswordException;
import in.micheal.exception.UserIdException;
import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

public class UserLoginAndRegistrationTest {

	@Test
	public void userRegistrationCheck() {

		try {
			UserDetailsDAO.deleteAllRecords();

			UserDetails obj = new UserDetails();
			long userId = 545454;
			String password = "878787";
			obj.setUserId(userId);
			obj.setPassword(password);
			boolean confirmation = false;

			confirmation = UserService.userRegistration(obj);

			assertTrue(confirmation);

			UserDetailsDAO.deleteAllRecords();
		} catch (DbException | UserIdException | InValidPasswordException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void repeatedUserIdCheck() {

		try {
			UserDetailsDAO.deleteAllRecords();

			UserDetails obj = new UserDetails();
			long userId = 878787;
			String password = "878787";
			obj.setUserId(userId);
			obj.setPassword(password);

			UserService.userRegistration(obj);

			UserDetails obj2 = new UserDetails();
			long userId2 = 878787;
			String password2 = "878787";
			obj2.setUserId(userId2);
			obj2.setPassword(password2);
			boolean confirmation = false;

			confirmation = UserService.userRegistration(obj2);

			assertFalse(confirmation);

			UserDetailsDAO.deleteAllRecords();
		} catch (DbException | UserIdException | InValidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void smallPasswordCheck() {

		UserDetails obj = new UserDetails();
		long userId = 121212;
		String password = "878";
		obj.setUserId(userId);
		obj.setPassword(password);

		try {
			UserService.userRegistration(obj);
		} catch (DbException | UserIdException | InValidPasswordException e) {
			String msg = e.getMessage();
			assertEquals("TOO WEAK PASSWORD", msg);
		}

	}

	@Test
	public void smallUserIdCheck() {

		UserDetails obj = new UserDetails();
		long userId = 121;
		String password = "878";
		obj.setUserId(userId);
		obj.setPassword(password);
		try {
			UserService.userRegistration(obj);
		} catch (DbException | UserIdException | InValidPasswordException e) {
			String msg = e.getMessage();
			assertEquals("INVALID USER ID", msg);

		}

	}
}
