/**
 * NoUpperAlphaException extends exception.
 * Delivers the requirements for the UpperCase exception class
 * @author Eric Gomez
 */
@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("Invalid: Password requires at least one uppercase alphabetic character");
	}

	public NoUpperAlphaException(String message) {
		super(message);
	}
}