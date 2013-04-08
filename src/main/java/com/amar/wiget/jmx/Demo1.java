package com.amar.wiget.jmx;

import java.util.concurrent.atomic.AtomicLong;

import javax.management.Notification;

import org.apache.log4j.Logger;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedNotifications;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Service;

@SuppressWarnings( "unused" )
@Service( "jmxDemo1" )
//@ManagedNotifications( value = { @ManagedNotification( name = "com.amar.wiget.jmx.HelloNotification" , notificationTypes = { "com.amar.wiget.jmx.Demo1" } ) } )
@ManagedResource( objectName = "annojmx:myjao=AnnotationObject" , description = "MyJavaAnnotationObject" )
public class Demo1 implements NotificationPublisherAware
{
	protected final Logger log = Logger.getLogger( this.getClass() );

	private final AtomicLong notificationSequence = new AtomicLong();

	private NotificationPublisher notificationPublisher;

	private int testAttribute;

	private String testAttribute2;

	@ManagedOperation
	public void start()
	{
		log.info( "start" );
	}

	public void init()
	{
		log.info( "init" );
	}

	@ManagedAttribute
	public int getTestAttribute()
	{
		return testAttribute;
	}

	@ManagedAttribute
	public void setTestAttribute( int testAttribute )
	{
		this.testAttribute = testAttribute;
	}

	@ManagedAttribute
	public String getTestAttribute2()
	{
		return testAttribute2;
	}

	@ManagedAttribute
	public void setTestAttribute2( String testAttribute2 )
	{
		this.testAttribute2 = testAttribute2;
	}

	@ManagedOperation
	public void trigger()
	{
		System.out.println( "trigger" );
		if ( notificationPublisher != null )
		{
			System.out.println(""+getClass().getName());
			Notification notification = new Notification( "type" , getClass().getName() , notificationSequence.getAndIncrement() , "The message" );
			notificationPublisher.sendNotification( notification );
		}
	}

	@Override
	public void setNotificationPublisher( NotificationPublisher notificationPublisher )
	{
		this.notificationPublisher = notificationPublisher;
	}
}
