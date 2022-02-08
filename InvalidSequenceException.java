/**
 * Exception class for passwords that have 2+ of the same character in
 * sequence 
 * Will contain a message.
 * 
 * @author ERic Gomez
 */

@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("Invalid: Password cannot have more than two of the same character in sequence");
	}

	public InvalidSequenceException(String message) {
		super(message);
	}
}