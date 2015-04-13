import javax.swing.JOptionPane;

/*
 * 
 */

public class Authentication
{
	/*** Class Constants ***/
	
	public static int MAXIMUM_ATTEMPTS = 4;
	
	/*** Class Variables ***/
	
	private static String pinNumber = "1234";
	private static int    attempts  = 0;
	
	/*** Class Methods ***/
	
	public static int getAttempts()
	{
	   return attempts;	
	}
	
	public static boolean verifyPIN( String pin )
	{
		/*** Local Variables ***/
		
		boolean pinStatus = false;  //Assume bad pin
		
		/*** Verify pin ***/
		
		if ( pinNumber.equals( pin ) )
		{
			pinStatus = true;
			clear();
		}	
		else
		{
			attempts++;
			if ( attempts >= MAXIMUM_ATTEMPTS )
			{
				JOptionPane.showMessageDialog( null, 
						"Contact Administrator!", 
						"User Information Message",
					    JOptionPane.INFORMATION_MESSAGE );				
			}
		}
			
		return pinStatus;
	}
	
	public static void clear()
	{
		attempts = 0;
	}
}