package in.micheal.util;

public class StringValidator {
	private StringValidator() {
		// default constructor
	}

	public static void lengthvalidator(String input) {
		if (input.length() < 4) {
			throw new RuntimeException("PASSWORD LENGTH MUST BE GREATER THAN 4 DIGITS");
		}
	}
}
