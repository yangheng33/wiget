package com.amar.wiget.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pool implements Runnable
{
	private String name = "";

	public Pool( String name )
	{
		this.name = name;
	}

	public static void main( String [] args )
	{
		BlockingQueue<Runnable> threadQueue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor( 5 , 10 , 20 , TimeUnit.SECONDS , threadQueue );

		for( int i = 0 ; i < 20 ; i ++ )
		{
			threadPoolExecutor.execute(  new Pool(i+"")  );
		}
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println( "now===>" + name );
			Thread.sleep( 5000 );
		}
		catch ( InterruptedException e )
		{
			e.printStackTrace();
		}
	}

}
