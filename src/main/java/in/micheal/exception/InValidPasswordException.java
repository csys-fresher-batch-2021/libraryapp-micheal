package in.micheal.exception;

public class InValidPasswordException extends Exception {
	/**
	 * 
	 * This methods throws Exception if password is smaller
	 */
	private static final long serialVersionUID = 1L;

	public InValidPasswordException(String message) {
		super(message);
	}
}
