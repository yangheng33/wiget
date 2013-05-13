package com.amar.wiget.thread;

public class Share
{
	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
	{
		public Integer initialValue()
		{
			return 0;
		}
	};
	
	public int getNextNum()
	{
		seqNum.set( ( Integer ) seqNum.get() + 1 );
		return ( Integer ) seqNum.get();
	}
}
