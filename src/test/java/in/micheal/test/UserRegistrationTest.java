package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

public class UserRegistrationTest {

	@Test
	public void userRegistrationCheck() {

		UserDetails obj = new UserDetails();
		long userId = 545454;
		String password = "878787";
		obj.setUserId(userId);
		obj.setPassword(password);
		boolean confirmation = false;

		try {
			confirmation = UserService.userRegistration(obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		assertTrue(confirmation);

	}

	@Test
	public void repeatedUserIdCheck() {

		UserDetails obj = new UserDetails();
		long userId = 878787;
		String password = "878787";
		obj.setUserId(userId);
		obj.setPassword(password);

		try {
			UserService.userRegistration(obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		UserDetails obj2 = new UserDetails();
		long userId2 = 878787;
		String password2 = "878787";
		obj2.setUserId(userId2);
		obj2.setPassword(password2);
		boolean confirmation = false;

		try {
			confirmation = UserService.userRegistration(obj2);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		assertFalse(confirmation);

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
		} catch (Throwable e) {
			String msg = e.getMessage();
			assertEquals("PASSWORD LENGTH MUST BE GREATER THAN 4 DIGITS", msg);

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
		} catch (Throwable e) {
			String msg = e.getMessage();
			assertEquals("INVALID USER ID", msg);

		}

	}
}
