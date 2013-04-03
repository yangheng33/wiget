package com.amar.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amar.common.AppInterface;
import com.amar.util.SpringBeanFactory;

@SuppressWarnings( "unused" )
public class App
{

	public static ApplicationContext contex;

	public static void main( String [] args )
	{
		App app = new App();
		app.loadXML();
		//AppInterface main = SpringBeanFactory.getBean( "" );
		//main.start();
	}

	public void loadXML()
	{
		contex = new ClassPathXmlApplicationContext( "config/amar-*.xml" );
	}

}
