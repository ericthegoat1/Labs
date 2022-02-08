
/**
 * Thrown if a password is less than six characters long.
 * @author Eric Gomez
 */
@SuppressWarnings("serial")
public class LengthException extends RuntimeException {
	/*
	 * Constructor
	 */
	public LengthException() {
		this("Invalid: The password must be more than 6 characters long");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public LengthException(String message) {
		super(message);
	}
}


