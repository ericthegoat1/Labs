/**
 * NoDigitException extends exception.
 * Delivers the requirements for the NoDigitException exception class
 * @author Eric Gomez
 */

@SuppressWarnings("serial")
public class NoDigitException extends Exception {
    public NoDigitException() {
		super("The password must contain at least one digit");
	}

	public NoDigitException(String message) {
		super(message);
	}
}
