package in.micheal.util;

public class StringValidator {
	private StringValidator() {
		// default constructor
	}

	public static void lengthvalidator(String input) throws Exception {
		if (input.length() < 4) {
			throw new Exception("PASSWORD LENGTH MUST BE GREATER THAN 4 DIGITS");
		}
	}
}
