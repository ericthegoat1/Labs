/**
 * WeakPasswordException for if the passwords do not match upon re-entry
 * 
 * @author Eric Gomez
 */

public class WeakPasswordException extends Exception {

	
	
	private static final long serialVersionUID = 1423L;

	public WeakPasswordException() {
		super("Invalid: The password is OK but weak");
	}

	public WeakPasswordException(String message) {
		super(message);
	}
}