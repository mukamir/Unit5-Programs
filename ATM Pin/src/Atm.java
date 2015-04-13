/*
 * 
 * 
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Atm extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	/*** Class Variables ***/
	                                      //GUI
	private JButton jbuAtm[] = null;
    private JPasswordField jpfPassword = null;  

	/*** Anonymous Inner classes ***/
	
	private class ButtonAction implements ActionListener
	{
        public void actionPerformed( ActionEvent e ) 
        {
           char password[] = null;
           
           password = jpfPassword.getPassword();
           
           String passwordString = Arrays.toString( password ) + ((AtmButton) e.getSource()).getText();

           passwordString = passwordString.replaceAll( "\\[", "" );
           passwordString = passwordString.replaceAll( "\\]", "" );
           passwordString = passwordString.replaceAll( ",",   "" );
           passwordString = passwordString.replaceAll( " ",   "" );

           jpfPassword.setText( passwordString );
           
           Arrays.fill( password, '\u0000' );
        }
    }

	private class ClearAction implements ActionListener
	{
        public void actionPerformed( ActionEvent e ) 
        {
            jpfPassword.setText( "" );       	
        }
    }	
	
	private class EnterAction implements ActionListener
	{
        public void actionPerformed( ActionEvent e ) 
        {
        	/*** Local Variables ***/
        	
            char password[] = null;
            String userPin = null;
            int attempts = 0;
            
            /*** Get password (pin) from field ***/
            
            password = jpfPassword.getPassword();
            
            userPin = Arrays.toString( password );   
            
            userPin = userPin.replaceAll( "\\[", "" );
            userPin = userPin.replaceAll( "\\]", "" );
            userPin = userPin.replaceAll( ",",   "" );
            userPin = userPin.replaceAll( " ",   "" );

            attempts = Authentication.getAttempts();
            
            if ( attempts >= Authentication.MAXIMUM_ATTEMPTS )
                displayMessage( "Too many attempts entering pin!  " +
                                "ATM locked! Contact Administrator!" );              	
            
            else
            {
            	if ( Authentication.verifyPIN( userPin ) )
            	{
	               displayMessage( "Welcome to the ATM Machine!" );   
	               Authentication.clear();
            	}
                else
                { 
                   attempts = Authentication.getAttempts();               	
            	   
                   if ( attempts < Authentication.MAXIMUM_ATTEMPTS )
                       displayMessage( "Authentication failed...Invalid Pin Number! " + "\n" +
        		            ( Authentication.MAXIMUM_ATTEMPTS - Authentication.getAttempts() )
        		            + " attempts left!");
                }
            	
                jpfPassword.setText( "" );                      
            }
            
            Arrays.fill( password, '\u0000' );
          }
    }
	
	/*** Class Methods ***/
	
	public Atm()
	{
		super( "ATM PIN AUTHENTICATION" );
		
		/*** Build GUI ***/
		
		buildGUI();
		
		/*** Set JFrame attributes ***/
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 800, 600 );
		center();
		pack();
		setVisible( true );
	}
	
	/*** Class helper methods ***/
	
	private void displayMessage( String message )
	{
		JOptionPane.showMessageDialog( null, message, "User Information Message",
			    JOptionPane.INFORMATION_MESSAGE );

	}
	
	private void center()
	{
		/*** Local Variables ***/
		
		Dimension dim = null;
		int frameWidth;
		int frameHeight;
		int frameLocationX;
		int frameLocationY;
				
		/*** Get the size of the primary screen being usd to display GUI ***/
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();

		/*** Calculate the new location of the container (JFrame) ***/
		
		frameWidth  = getSize().width;
		frameHeight = getSize().height;

		frameLocationX = ( dim.width  - frameWidth  ) / 2;
		frameLocationY = ( dim.height - frameHeight ) / 2;

		/*** Center container by setting upper left hand corner on screen ***/
		
		setLocation( frameLocationX, frameLocationY ); 
	}

	private void buildGUI()
	{
		/*** Local Variables ***/
		
		JPanel jpaPassword = null;
		JPanel jpaAtmKeypad = null;
		
		/*** Instantiate GUI Components ***/
		
		setLayout( new BorderLayout() );
		
		jpaPassword  = createPasswordPanel();
		jpaAtmKeypad = createAtmKeypadPanel();	
		
		/*** Add GUI Components to the container (JFrame) ***/

		add( "North", jpaPassword );
		add( "South", jpaAtmKeypad );
	}
	
	private JPanel createAtmKeypadPanel()
	{	
		/*** Local Variables ***/
		
		JPanel  jpaAtmKeypad = null;
		
		jbuAtm = new JButton[ 12 ];	
		
		/*** Instantiate GUI Components ***/
		
		jpaAtmKeypad = new JPanel();
		jpaAtmKeypad.setLayout( new GridLayout( 4, 3 ) );
		
		for ( int i = 0; i < 9; i++ )
		{
			jbuAtm[ i ] = new AtmButton( "" + (i+1) );
			jbuAtm[ i ].addActionListener( new ButtonAction() );
		}
		
		jbuAtm[  9 ] = new AtmButton( "C" );
		jbuAtm[  9 ].addActionListener( (ActionListener) new ClearAction() );
		jbuAtm[ 10 ] = new AtmButton( "0" );
		jbuAtm[ 10 ].addActionListener( (ActionListener) new ButtonAction() );
		jbuAtm[ 11 ] = new AtmButton( "E" );	  //new JButton( pass in image );
		jbuAtm[ 11 ].addActionListener( (ActionListener) new EnterAction() );
		
		/*** Add GUI components to container (JPanel) ***/
		
		for ( int i = 0; i < jbuAtm.length; i++ )
		{
			jpaAtmKeypad.add( jbuAtm[ i ] );
		}

		/*** Return container ***/
		
		return jpaAtmKeypad;
	}
	
	private JPanel createPasswordPanel()
	{
		/*** Local Variables ***/
		
		JPanel jpaPassword= null;
		
		/*** Instantiate GUI Components ***/
		
        jpaPassword = new JPanel();
		
        jpfPassword = new JPasswordField( 8);
        jpfPassword.setFont( new Font( "Courier New", Font.BOLD, 48 ) );
        jpfPassword.setEditable( false );
		
		/*** Add GUI components to container (JPanel) ***/
		
        jpaPassword.add( jpfPassword );
		
		/*** Return container ***/
		
		return jpaPassword;
	}
	
	/*** Application ***/
	
	public static void main( String args[] )
	{
		new Atm(); 
	}
}