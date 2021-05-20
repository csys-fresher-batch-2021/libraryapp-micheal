package in.micheal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import in.micheal.model.UserDetails;
import in.micheal.service.UserService;

public class UserLoginTest {

	@Test
	public void validLoginCredentials() {
		UserDetails obj = new UserDetails();
		long userId = 989898;
		String password = "878787";
		obj.setUserId(userId);
		obj.setPassword(password);

		try {
			UserService.userRegistration(obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		boolean confirmation = UserService.userLogin(userId, password);
		assertTrue(confirmation);

	}

	@Test
	public void invalidLoginCredentials() {
		UserDetails obj = new UserDetails();
		long userId = 676767;
		String password = "878787";
		obj.setUserId(userId);
		obj.setPassword(password);

		try {
			UserService.userRegistration(obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		boolean confirmation = UserService.userLogin(98765L, password);
		assertFalse(confirmation);

	}

}
