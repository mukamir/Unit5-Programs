/*
 * Author: Amirkhan Mukashev
 * email: am25524@email.vccs.edu
 * Last edit: 04/12/2015
 */

import java.awt.*;
import javax.swing.*;

public class Parabola extends JFrame
{
	private static final long serialVersionUID = 1L;

	/*** Class Methods ***/
	
	public Parabola()
	{
		super( "Parabola" );
		
		/*** Build GUI ***/
		
		buildGUI();
		
		/*** Set JFrame attributes ***/
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 500, 500 );
		center();
		//pack();
		setVisible( true );
	}
	
	/*** Inner class GraphPenel ***/
	
	private class GraphPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent( Graphics g )
		{
			/*** Local Variables ***/
		
			Polygon polygon = new Polygon();
			double scaleFactor = 0.1;
			int xCoordinate = 0;			
			int yCoordinate = 0;
			
			/*** Add points to polygon object ***/
			
			for ( int x = -100; x <= 100; x++ )
			{
			   xCoordinate = x + 200;
			   yCoordinate = 200 - (int) (scaleFactor * x * x );
			   
			   polygon.addPoint( xCoordinate, yCoordinate );
			}
			
			/*** Draw x and y axis ***/
			
			g.drawLine(   0, 200, 400, 200 );  // x axis			
			g.drawLine( 200,   0, 200, 400 );  // y axis
			
			/*** Draw x and y labels ***/
			
			g.drawString( "x axis", 300, 180  );
			g.drawString( "y axis", 220, 300 );
			
			/*** Draw parabola graph on screen ***/
			
			g.drawPolyline( polygon.xpoints, polygon.ypoints, polygon.npoints );
		}
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
		
		JPanel jpaGraphPanel = null;
		
		/*** Instantiate GUI Components ***/
		
		jpaGraphPanel = new GraphPanel();
		
		/*** Add GUI Components to the container (JFrame) ***/
		
		add( jpaGraphPanel );
	}
	
	/*** Application ***/
	
	public static void main( String args[] )
	{
		new Parabola(); 
	}
}
