package com.amar.wiget.mina.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

import com.amar.util.DataTool;

public class ClientSender implements Runnable
{
	protected Socket socket;

	protected OutputStream os;

	protected Vector<String> info;

	public ClientSender( Socket socket , OutputStream os , Vector<String> info )
	{
		this.socket = socket;
		this.os = os;
	}

	protected String [] content = { "amar", "hello", "yangheng33", "undead", "human", "qingshanji", "quit" };

	@Override
	public void run()
	{
		while ( ClientDemo1.connected )
		{
			try
			{
				int c = new Random().nextInt( 10 ) % content.length;
				byte [] bytes = new String( content[ c ] ).getBytes( "UTF-8" );
				byte [] data = new byte [ bytes.length + 4 ];
				byte [] length = DataTool.intToByte( bytes.length + 4 );

				System.arraycopy( length , 0 , data , 0 , length.length );
				System.arraycopy( bytes , 0 , data , 4 , bytes.length );

				os.write( data );
				System.out.println( "send:" + content[ c ] );

				if ( content[ c ].equals( "quit" ) )
				{
					ClientDemo1.connected = false;
				}
				Thread.sleep( 1000 );

			}
			catch ( IOException e )
			{
				e.printStackTrace();
				break;
			}
			catch ( InterruptedException e )
			{
				e.printStackTrace();
				break;
			}
		}
	}

}
