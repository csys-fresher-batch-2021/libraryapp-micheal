package in.micheal.exception;

public class UserIdException extends Exception {
	/**
	 * This method rises Exception if user ID is not valid
	 */
	private static final long serialVersionUID = 1L;

	public UserIdException(String message) {
		super(message);
	}

}