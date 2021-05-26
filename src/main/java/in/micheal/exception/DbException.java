package in.micheal.exception;

public class DbException extends Exception {
	/**
	 * User defined DBexception
	 */
	private static final long serialVersionUID = 1L;

	public DbException(String message) {
		super(message);
	}
}
