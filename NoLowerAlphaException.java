/**
 * 
 * @author Eric Gomez
 *The following is a class for the lower alpha exception
 */

public class NoLowerAlphaException extends Exception{
	public NoLowerAlphaException() {
		super("Invalid: password requires at least one lower case alphabetic character");
	}
}