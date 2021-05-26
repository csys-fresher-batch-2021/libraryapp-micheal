package in.micheal.exception;

public class InValidPasswordException extends Exception {
	/**
	 * 
	 * User defined invalid password exception
	 */
	private static final long serialVersionUID = 1L;

	public InValidPasswordException(String message) {
		super(message);
	}
}
