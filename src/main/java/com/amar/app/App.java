package com.amar.app;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amar.dao.ProjectDAO;
import com.amar.model.Project;
import com.amar.util.SpringBeanFactory;
import com.amar.util.TimeDateUtil;

@SuppressWarnings( "unused" )
public class App
{
	private final static Logger log = Logger.getLogger( App.class );

	public static ClassPathXmlApplicationContext contex;

	public static void main( String [] args )
	{
		App app = new App();
		app.loadXML();
		// AppInterface main = SpringBeanFactory.getBean( "" );
		// main.start();
		// app.stop();
		//app.insert();
	}

	public void insert()
	{
		ProjectDAO dao = SpringBeanFactory.getBean( "projectDAO" );
		String [] city = { "北京", "上海", "广州", "西安" };

		Date start = new Date();
		for( long i = 0 ; i < 1000000 ; i ++ )
		{
			Project project = new Project();
			int poisition = new Random().nextInt( city.length - 1 );
			project.setRemark( "" + poisition );
			project.setName( city[ poisition ] );
			dao.addProject( project );
		}
		Date end = new Date();
		
		log.info( "用时:"+( end.getTime()-start.getTime() )/1000 );
		stop();
	}

	public static void stop()
	{
		int i = 5;
		while ( i > 0 )
		{
			try
			{
				log.info( i + "==>" + TimeDateUtil.getDateTime( new Date() ) );
				Thread.sleep( 1000 );
				i -- ;
			}
			catch ( InterruptedException e )
			{
				e.printStackTrace();
			}
		}
		contex.destroy();
		log.info( i + "==>stop" );
	}

	public void loadXML()
	{
		contex = new ClassPathXmlApplicationContext( "config/amar-*.xml" );
	}

}
