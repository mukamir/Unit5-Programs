/*
 * Author: Amirkhan Mukashev
 * email: am25524@email.vccs.edu
 * Last edit: 04/12/2015
 */

import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame
{
	private static final long serialVersionUID = 1L;

	/*** Class Methods ***/
	
	public GridLayoutDemo()
	{
		super( "GridLayout Demo" );
		
		/*** Build GUI ***/
		
		buildGUI();
		
		/*** Set JFrame attributes ***/
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 300, 250 );
		center();
		pack();
		setVisible( true );
	}
	
	/*** Class helper methods ***/
	
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
		
		JPanel jpaPanel1 = null;
		JPanel jpaPanel2 = null;
		
		/*** Instantiate GUI Components ***/
		
		setLayout( new BorderLayout() );
		
		jpaPanel1 = createPanel1();
		jpaPanel2 = createPanel2();	
		
		/*** Add GUI Components to the container (JFrame) ***/
		
		add( "Center", jpaPanel2 );
		add( "South",  jpaPanel1 );
	}
	
	private JPanel createPanel1()
	{	
		/*** Local Variables ***/
		
		JPanel jpaPanel1 = null;
		
		JButton jbuButton1 = null;	
		JButton jbuButton2 = null;
		JButton jbuButton3 = null;
		
		/*** Instantiate GUI Components ***/
		
		jpaPanel1 = new JPanel();
		jpaPanel1.setLayout( new GridLayout( 2, 2 ) );
		
		jbuButton1 = new JButton( "Button 1" );
		jbuButton2 = new JButton( "Button 2" );
		jbuButton3 = new JButton( "Button 3" );
		
		/*** Add GUI components to container (JPanel) ***/
		
		jpaPanel1.add( jbuButton1 );
		jpaPanel1.add( jbuButton2 );
		jpaPanel1.add( jbuButton3 );
		
		/*** Return container ***/
		
		return jpaPanel1;
	}
	
	private JPanel createPanel2()
	{
		/*** Local Variables ***/
		
		JPanel jpaPanel2 = null;
		
		JButton jbuButton4 = null;	
		JButton jbuButton5 = null;
		JButton jbuButton6 = null;
		
		/*** Instantiate GUI Componenets ***/
		
		jpaPanel2 = new JPanel();
		jpaPanel2.setLayout( new GridLayout( 2, 2 ) );
		
		jbuButton4 = new JButton( "Button 4" );
		jbuButton5 = new JButton( "Button 5" );
		jbuButton6 = new JButton( "Button 6" );
		
		/*** Add GUI components to container (JPanel) ***/
		
		jpaPanel2.add( jbuButton4 );
		jpaPanel2.add( jbuButton5 );
		jpaPanel2.add( jbuButton6 );
		
		/*** Return container ***/
		
		return jpaPanel2;
	}
	
	/*** Application ***/
	
	public static void main( String args[] )
	{
		new GridLayoutDemo(); 
	}
}
