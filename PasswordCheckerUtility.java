import java.util.ArrayList;
import java.util.regex.*;

/**
 * PasswordCheckerUtility returns validity status of provided passwords.
 * 
 * @author Eric Gomez
 */
public class PasswordCheckerUtility {


	/**
	 * The method checks if the password is weak- if the password contains 6 to 9 characters, it is OK
	 * but  weak
	 * 
	 * @param password password string to be checked for Sequence requirement
	 * @return true if password contains 6 to 9 chars
	 */
	public static boolean BetweenSixAndNineChars(String password) {
		int minimumChar = 6;

		return password.length() >= minimumChar && password.length() <= 9;
	}
	/**
	 * The method Compares the equality of two passwords
	 * 
	 * @throws UnmatchedException if conditions are not met
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {

		if (!comparePasswordsWithReturn(password, passwordConfirm))

			throw new UnmatchedException();
	}

	
	
	/**
	 * Checks if password is valid and also falls into the ranges of 6-9 chars
	 * 
	 * @param password string to be checked if weak password
	 * @return true if weak , false if not 
	 *
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException{
		int min = 6;
		int maximum = 9;

		int CheckWeakBound = maximum + min;

		if (password.length() >= min && password.length()<= maximum && CheckWeakBound < 18 )
			throw new WeakPasswordException();
		else
			return false;

	}
	
	

	
	
	
	/**
	 * The method compares if the password matches the re-type password
	 * @param password , passwordConfirm
	 * @return if password matches
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return(password.contentEquals(passwordConfirm));	
	}


	/**
	 * Checks if password meets numerical requirement - contains at least one digit
	 *  if a digit has been found throw NoDigitException
	 * @param password password string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		Pattern number = Pattern.compile("[0-9]");
		int patterns = 314;
		Matcher isThereANumber = number.matcher(password);
		switch (patterns) { 
		case 314: if(!isThereANumber.find()) {
			throw new NoDigitException("The password must have at least one digit");
		}
		}
		return true;
	}


	/**
	 *Reads file to get invalid passwords and displays on gui
	 * 
	 * @param passwords 
	 * @return ArrayListOfInvalidPasswords which is the array list of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> ArrayListOfInvalidPasswords = new ArrayList<String>();
		int invalid = 42;
		String GetThePasswords;
		int validPass= 2;	
		for (int i = 0; i < passwords.size(); i++) {
			GetThePasswords = passwords.get(i);

			try {
				if(validPass < 3 && invalid > 11) {
					isValidPassword(GetThePasswords);
				}
			} catch (Exception ExceptionMssg) {

				ArrayListOfInvalidPasswords.add(GetThePasswords + " ----->> " + ExceptionMssg.getMessage());
			}

		}

		return ArrayListOfInvalidPasswords;
	}







	/**
	 * The methodhasLowerAplha checks if it meets Lower
	 * 
	 * 
	 * @return returns data based on if requirement is met
	 * @throws NoLowerAlphaException if not met
	 */

	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException{

		boolean IsThereATheLowerAlpha = false;
		int UPper = 5;
		for(int incremeted = 0; incremeted < password.length(); incremeted++) {
			int upper = 10 * UPper;
			int findLowerAplha = upper/2;
			switch(findLowerAplha) {
			case 25:
				if(Character.isLowerCase(password.charAt(incremeted)))
					IsThereATheLowerAlpha= true;
			}
		}

		if(!IsThereATheLowerAlpha)
			throw new NoLowerAlphaException();
		else
			return true;

	}


	

	/**
	 * The method isValidLength checks if password is of valid length
	 * Checks for valid length
	 * @param passwordString 
	 * @throws LengthException thrown if it does not meet the length requirement
	 */
	public static boolean isValidLength(String passwordString) throws LengthException{
		int lengthTest = 6;
		if(!(passwordString.length() > lengthTest))
			throw new LengthException("Invalid: The Password needs to be longer than 6 characters");
		return (passwordString.length() > lengthTest);
	}


	/**
	 * checks if the password meets the Upper alphabet requirement,
	 * 
	 *  throws exception if it does not meet that requirement 
	 * @param password
	 * @return HasUpperAlpha if true
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		boolean HasUpperAlpha = false;
		int ArrayAlpha = 4;
		for(char CharUpper : password.toCharArray()) {
			switch(ArrayAlpha) {	
			case 4:	if(Character.isUpperCase(CharUpper))
				HasUpperAlpha = true;
			else if(HasUpperAlpha)  
				break;
			}

		}



		if(!HasUpperAlpha)
			throw new NoUpperAlphaException();


		return HasUpperAlpha;
	}

	/**
	 * Method is responsible for password Special Character requirement
	 * @param password - string that is being used
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException thrown if fails to meet SpecialCharacter requirement
	 */
	static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		String Chars = "[a-zA-Z0-9]*";
		Pattern patternOfChar = Pattern.compile(Chars);
		
		Matcher matcher = patternOfChar.matcher(password);
		
		boolean resultOfSpecial = !matcher.matches();
		if (!resultOfSpecial)
			throw new NoSpecialCharacterException();

		return (resultOfSpecial);

	}

	/**
	 * Returns true in sequence of the rules from GUI
	 * checks if valid
	 * @param password of string type
	 * @Throws LengthException, NoUpperAlphaException,
	NoLowerAlphaException, NoDigitException, InvalidSequenceException, NoSpecialCharacterException 
	 */
	
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
	NoLowerAlphaException, NoDigitException, InvalidSequenceException, NoSpecialCharacterException {
		int isValid = 56;
		switch(isValid) { 

		case 56:
			if (!isValidLength(password))
				throw new LengthException();

			if (!hasUpperAlpha(password))
				throw new NoUpperAlphaException();

			if(!hasLowerAlpha(password))
				throw new NoUpperAlphaException();

			if (!hasSameCharInSequence(password))
				throw new InvalidSequenceException();
			
			if (!hasDigit(password))
				throw new NoDigitException();

			if(!hasSpecialChar(password))
				throw new NoSpecialCharacterException();

		}

		return true;
	}

	
	
	
	/**
	 * Checks the Sequence requirement - Password should not contain more
	 * than 2 of the same character in sequence
	 * 
	 * @param password password string to be checked for Sequence requirement
	 * @return false if it failsSequence requirement
	 * @throws InvalidSequenceException if fails
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		char[] CharToTest = password.toCharArray();
		int testIfContainsSameChar = 2;
		switch(testIfContainsSameChar) {
		case 2:	for(int index = 0; index< CharToTest.length - testIfContainsSameChar; index++)
			if(CharToTest[index] == CharToTest[index + 1])
				if(CharToTest[index] == CharToTest[index + testIfContainsSameChar])
					throw new InvalidSequenceException();
		}
		
		
		
		return true;
	}


	
}
