package com.amar.util.math;

public class Calculate3d
{

	public static void main( String [] args )
	{
		Vector3d b = new Vector3d( 1 , 1.732f , 0 );

		Vector3d a = new Vector3d( 0 , 1 , 0 );

		System.out.println( "sin:" + Math.asin( 0.5 ) * 180 / Math.PI );
		System.out.println( "crossMultiply:" + Math.acos( a.cosAngle( b ) ) * 180 / Math.PI );
		System.out.println( "crossMultiply:" + a.crossMultiply( b ) );
	}

}
