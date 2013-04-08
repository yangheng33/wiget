package com.amar.common;

public interface Monitor
{
	public void init();

	public void start();

	public void stop();

	public String getState();

	public void setName( String name );

	public String getName();
}
