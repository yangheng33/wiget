package com.amar.wiget.jms.demo1;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.transport.discovery.DiscoveryTransport;
import org.apache.activemq.transport.failover.FailoverTransport;

import com.amar.util.TimeDateUtil;

@SuppressWarnings( "unused" )
public class TestActiveMQ
{
	public static String url3= "tcp://192.168.8.185:61616";

	public static String url2 = "failover:(tcp://192.168.8.185:61616,tcp://192.168.8.33:61617)?initialReconnectDelay=100&timeout=10000";

	public static String url ="discovery:(multicast://default)?initialReconnectDelay=100&timeout=10000";
	
	public static void main( String [] args ) throws JMSException , InterruptedException
	{
		new TestActiveMQ().topic();
	}

	public void queue() throws JMSException , InterruptedException
	{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( url );
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession( true , Session.AUTO_ACKNOWLEDGE );
		Queue queue = session.createQueue( "jmsQueueTest" );

		MessageProducer producer = session.createProducer( queue );

		Date start = new Date();
		int length = 300;
		for( int j = 0 ; j < length ; j ++ )
		{
			ObjectMessage message = session.createObjectMessage();
			message.setStringProperty( "number" , "" + j + "" );
			message.setStringProperty( "date" , TimeDateUtil.getDateTime( new Date() ) );
			producer.send( message );
			session.commit();
			System.out.println( "发送" + j );
		}
		session.close();
		connection.close();
		Date end = new Date();
		System.out.println( "发送" + length + "条数据用时：" + ( end.getTime() - start.getTime() ) );

	}

	/**
	 * @param args
	 * @throws JMSException
	 * @throws InterruptedException
	 */
	public void topic() throws JMSException , InterruptedException
	{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( url2);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession( true , Session.AUTO_ACKNOWLEDGE );

		Topic topic = session.createTopic( "alarmTopic" );

		MessageProducer producer = session.createProducer( topic );

		Date start = new Date();
		int length = 100000;
		for( int j = 0 ; j < length ; j ++ )
		{
			ObjectMessage message = session.createObjectMessage();
			message.setStringProperty( "number" , "" + j + "" );
			message.setStringProperty( "date" , TimeDateUtil.getDateTime( new Date() ) );
			// MapMessage message = ( MapMessage ) msg;
			producer.send( message );
			session.commit();
		}
		session.close();
		connection.close();
		Date end = new Date();
		System.out.println( "发送" + length + "条数据用时：" + ( end.getTime() - start.getTime() ) );
	}
}
