package com.amar.wiget.rmi.demo1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service( "helloRmiServiceImpl" )
@Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
public class HelloRmiServiceImpl implements HelloRmiService
{

	public int getAdd( int a , int b )
	{
		return a + b;
	}
}
