package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

public class UserRegistrationTest {

	@Test
	public void userRegistrationCheck() {
		try {
			UserDetails obj = new UserDetails();
			long userId = 545454;
			String password = "878787";
			obj.setUserId(userId);
			obj.setPassword(password);
			boolean confirmation;

			confirmation = UserService.userRegistration(obj);

			assertTrue(confirmation);
		} catch (Exception e) {
			// Auto-generated catch block
		}
	}

	@Test
	public void repeatedUserIdCheck() {
		try {
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
		} catch (Exception e) {
			// Auto-generated catch block
		}

	}

	@Test
	public void smallPasswordCheck() {
		try {
			UserDetails obj = new UserDetails();
			long userId = 121212;
			String password = "878";
			obj.setUserId(userId);
			obj.setPassword(password);

			UserService.userRegistration(obj);
		} catch (Exception e) {
			String msg = e.getMessage();
			assertEquals("PASSWORD LENGTH MUST BE GREATER THAN 4 DIGITS",msg);

		}
	}

}
