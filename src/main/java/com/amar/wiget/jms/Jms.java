package com.amar.wiget.jms;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import com.amar.constant.ProjectInfo;

@Service( "jms" )
public class Jms
{
	public static final String NAME = "jms";

	private Connection connection;
	
	@Resource( name = "projectInfo" )
	private ProjectInfo projectInfo;

	private ConnectionFactory connectionFactory;

	@PostConstruct
	public void init()
	{
		try
		{
			connectionFactory = new ActiveMQConnectionFactory( projectInfo.jmsAddress() );
			connection = connectionFactory.createConnection();
			connection.start();
			System.out.println( "jms start." );
		}
		catch ( JMSException e )
		{
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		try
		{
			if ( connection == null )
			{
				connection = connectionFactory.createConnection();
			}
		}
		catch ( JMSException e )
		{
			e.printStackTrace();
		}
		return connection;
	}

	public void send( Map<String,String> dataMap , String topicname )
	{
		try
		{
			Session session = getConnection().createSession( true , Session.AUTO_ACKNOWLEDGE );
			Topic topic = session.createTopic( topicname );
			MessageProducer producer = session.createProducer( topic );
			
			ObjectMessage message = session.createObjectMessage();
			
			Iterator<String> itor = dataMap.keySet().iterator();
			while( itor.hasNext())
			{
				String key = itor.next();
				message.setStringProperty( key , dataMap.get( key ) );
			}
			
			producer.send( message );
			session.commit();
			session.close();
		}
		catch ( JMSException e )
		{
			e.printStackTrace();
		}
	}
}
