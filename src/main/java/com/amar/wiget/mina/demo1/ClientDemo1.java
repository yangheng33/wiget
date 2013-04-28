package com.amar.wiget.mina.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientDemo1
{
	protected Socket socket;

	protected OutputStream os;

	protected InputStream is;

	public static boolean connected = true;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String [] args )
	{
		ClientDemo1 client = new ClientDemo1();
		client.connect( "192.168.8.33" , 6488 );

		ClientReceiver clientReceiver = new ClientReceiver( client.socket , client.is , null );
		ClientSender clientSender = new ClientSender( client.socket , client.os , null );

		Thread receiver = new Thread( clientReceiver );
		receiver.setName( "receiver" );

		Thread sender = new Thread( clientSender );
		sender.setName( "sender" );

		receiver.start();
		sender.start();

	}

	public boolean connect( String ip , int port )
	{
		boolean re = false;
		try
		{
			socket = new Socket();
			InetSocketAddress isa = new InetSocketAddress( ip , port );
			socket.connect( isa , 5000 );
			os = socket.getOutputStream();
			is = socket.getInputStream();
			re = true;
		}
		catch ( IOException e )
		{
			close();
		}

		return re;
	}

	public void close()
	{
		try
		{
			if ( socket != null )
			{
				socket.close();
				socket = null;
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}
