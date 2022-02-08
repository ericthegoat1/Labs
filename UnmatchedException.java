/**
 * UnmatchedException for if the passwords do not match upon re-entry
 * 
 * @author Eric Gomez
 */

@SuppressWarnings("serial")
public class UnmatchedException extends Exception {
	public UnmatchedException() {
		super("Invalid: The passwords do not match");
	}

	public UnmatchedException(String message) {
		super(message);
	}
}
