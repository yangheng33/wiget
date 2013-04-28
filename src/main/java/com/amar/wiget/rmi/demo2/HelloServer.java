package com.amar.wiget.rmi.demo2;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer
{
	public static void main( String args[] )
	{
		// public void main(String args[]) {
		try
		{
			IHello rhello = new HelloImpl();
			LocateRegistry.createRegistry( 8888 );

			// 这两种方式都行
			Naming.bind( "rmi://localhost:8888/RHello" , rhello );
			// Naming.bind("//localhost:8888/RHello",rhello);

			System.out.println( ">>>>>INFO:绑定RHello成功." );
		}
		catch ( RemoteException e )
		{
			System.out.println( e.toString() );
			e.printStackTrace();
		}
		catch ( AlreadyBoundException e )
		{
			System.out.println( e.toString() );
			e.printStackTrace();
		}
		catch ( MalformedURLException e )
		{
			System.out.println( e.toString() );
			e.printStackTrace();
		}
	}
}
