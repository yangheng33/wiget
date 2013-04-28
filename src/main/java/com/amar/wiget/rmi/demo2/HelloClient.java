package com.amar.wiget.rmi.demo2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient
{

	public static void main( String args[] )
	// public void main( String args[] )
	{
		try
		{
			IHello rhello = ( IHello ) Naming.lookup( "rmi://localhost:8888/RHello" );
			System.out.println( rhello.helloWorld() );
			System.out.println( rhello.sayHelloToSomeBody( "你好!" ) );
		}
		catch ( NotBoundException e )
		{
			e.printStackTrace();
		}
		catch ( MalformedURLException e )
		{
			e.printStackTrace();
		}
		catch ( RemoteException e )
		{
			e.printStackTrace();
		}
	}
}
