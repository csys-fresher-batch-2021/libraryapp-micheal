package in.micheal.exception;

public class UserIdException extends Exception {
	/**
	 * userdefined invalid user id exception
	 */
	private static final long serialVersionUID = 1L;

	public UserIdException(String message) {
		super(message);
	}

}