package com.amar.common;

public abstract class BaseMonitor implements Monitor
{
	protected String state = "stop";
	protected String name = "";
	
	@Override
	public void start()
	{
		state = "start";
		while( state.equalsIgnoreCase( "start" ))
		{
			System.out.println(name+" in start");
			try
			{
				Thread.sleep( 3000 );
			}
			catch ( InterruptedException e )
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop()
	{
		state="stop";
	}

	@Override
	public String getState()
	{
		return state;
	}

	@Override
	public void setName( String name )
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

}
