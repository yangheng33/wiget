package com.amar.wiget.jmx;

import org.springframework.jmx.export.annotation.ManagedResource;

import com.amar.common.BaseApp;

@ManagedResource( objectName = "annojmx:myjao=AnnotationObject" , description = "MyJavaAnnotationObject" )
public class Demo1 extends BaseApp
{
	@Override
	public void start()
	{
		log.info( "start" );
		
	}

	@Override
	public void init()
	{
		log.info( "init" );
	}

}
