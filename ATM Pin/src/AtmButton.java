/*
 * 
 * 
 * 
 */

import java.awt.*;
import javax.swing.*;

public class AtmButton extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AtmButton( String title )
	{
		super( title );
		
		setFont( new Font( "Courier New", Font.BOLD, 48 ) );		
	}
}