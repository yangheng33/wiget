package com.amar.wiget.mina.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Vector;

public class ClientReceiver implements Runnable
{
	protected Socket socket;

	protected InputStream is;

	protected Vector<String> info;

	public ClientReceiver( Socket socket , InputStream is , Vector<String> info )
	{
		this.socket = socket;
		this.is = is;
	}

	@Override
	public void run()
	{
		while ( ClientDemo1.connected )
		{
			try
			{
				byte [] bytes = new byte [ 1024 ];
				int length = is.read( bytes );
				if ( length > - 1 )
				{
					byte [] data = new byte [ length ];
					for( int i = 0 ; i < length ; i ++ )
					{
						data[ i ] = bytes[ i ];
					}
					String dataString = new String( data );

					System.out.println( "receive:" + dataString );
				}
			}
			catch ( IOException e )
			{
				e.printStackTrace();
				break;
			}
		}
	}

}
