import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Eric Gomez
 *
 */
public class PasswordCheckerTest_STUDENT {
ArrayList <String> ArrayOfPasswords;
	@Before
	public void setUp() throws Exception {
		String[] PasswordStrings = {"abDD*1", "1234ABC", "ericstest1!",
				"passwordwill**123AB", "weakpass","321" , "Dddddd5%"  ,"BgtF8^!"};
		ArrayOfPasswords = new ArrayList <String>();
		ArrayOfPasswords.addAll(Arrays.asList(PasswordStrings));
	}

	@After
	public void tearDown() throws Exception {
	ArrayOfPasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		
		
		//Try catch on Dddddd5% and should return true no exception
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(ArrayOfPasswords.get(6)));
		}
		catch (LengthException exc) {
			fail("This password did not to pass length requirements");
		}
		
		
		
	//This should test "321" and throws length exception
	Throwable TooShortException = assertThrows(LengthException.class, new Executable()
			{

				@Override
				public void execute() throws Throwable {
					PasswordCheckerUtility.isValidLength(ArrayOfPasswords.get(5));
					
				}
		
			});assertEquals("The password must be at least 6 characters long", TooShortException.getMessage());
	
	

			
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		
		
		
		//Should not throw exception
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(ArrayOfPasswords.get(1)));
		}
		catch(NoUpperAlphaException noAL) {
			fail ("the password did not pass the Upper Alhpha");
			
		}
		
		
		
		
		Throwable TheresNoUpperAlpha = assertThrows(NoUpperAlphaException.class, new Executable() {
			//tests ericstest1
			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				PasswordCheckerUtility.hasUpperAlpha(ArrayOfPasswords.get(2));
			}
			
		});assertEquals("The password must contain at least one uppercase alphabetic character", TheresNoUpperAlpha.getMessage());
				
	
		
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		
		
		// test weakpass it should not throw an exception
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(ArrayOfPasswords.get(4)));
		}
		catch(NoLowerAlphaException e) {
			fail("Error: Failed the lower alpha requirements");
		}
		
		
		//Should throw the exception
		Throwable noLower = assertThrows(NoLowerAlphaException.class, new Executable (){

			@Override
			public void execute() throws Throwable {
			PasswordCheckerUtility.hasLowerAlpha(ArrayOfPasswords.get(1));
				
			}
			
		}) ;assertEquals("The password must contain at least one lowercase alphabetic character", noLower.getMessage());
		
		
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		
		Throwable exc = assertThrows(WeakPasswordException.class, new Executable() {

			@Override
			//test abDD*1 and it should throw the exception
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword(ArrayOfPasswords.get(0));
				
			}
			
		});
		
		assertEquals("The following password is OK but weak", exc.getMessage());
		
		//tests "passwordwill**123AB"
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(ArrayOfPasswords.get(3)));
		}
		catch(WeakPasswordException e ) {
			fail("failed to meet the valid password requirements");
		}
		
		
		
		
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		
		
		
		// should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(ArrayOfPasswords.get(2)));
		}
		catch (InvalidSequenceException exc) {
			fail("This password was supposed to pass sequence requirements.");
		}
		
		
		// should throw a InvalidSequenceException
		Throwable exception = assertThrows(InvalidSequenceException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence(ArrayOfPasswords.get(6));
			}
		});		
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());

	
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		// Test weakpass should throw an expception
		Throwable exception = assertThrows(NoDigitException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(ArrayOfPasswords.get(4));
			}
		});		
		assertEquals("The password must contain at least one digit", exception.getMessage());

		// Test ericstest1! should not throw an exception and return "True"
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(ArrayOfPasswords.get(2)));
		}
		catch (NoDigitException e) {
			fail("This password was supposed to pass digit requirements.");
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		
		//SHOULD NOT THROW AN EXCEPTION
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(ArrayOfPasswords.get(2)));
			assertTrue(PasswordCheckerUtility.isValidPassword(ArrayOfPasswords.get(3)));
		}
		catch (Exception e) {
		
		fail("The passwords were expected to be valid");
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(ArrayOfPasswords);
		assertEquals(results.size(), 6);
		}
	
}
