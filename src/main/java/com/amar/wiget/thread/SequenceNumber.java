package com.amar.wiget.thread;

public class SequenceNumber implements Runnable
{
	private Share sn;

	public SequenceNumber()
	{
	}

	public SequenceNumber( Share sn )
	{
		this.sn = sn;
	}

	public static void main( String [] args )
	{
		Share share = new Share();
		// ③ 3个线程共享sn，各自产生序列号
		SequenceNumber sn1 = new SequenceNumber( share );
		SequenceNumber sn2 = new SequenceNumber( share );
		SequenceNumber sn3 = new SequenceNumber( share );

		Thread tsn1 = new Thread(sn1);
		Thread tsn2 = new Thread(sn2);
		Thread tsn3 = new Thread(sn3);
		
		tsn1.start();
		tsn2.start();
		tsn3.start();

	}

	public void run()
	{
		// ④每个线程打出3个序列值
		for( int i = 0 ; i < 3 ; i ++ )
		{
			System.out.println( "thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]" );
		}
	}

}
