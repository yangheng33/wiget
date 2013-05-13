package com.amar.wiget.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpDemo1
{

	public static void main( String [] args ) throws URISyntaxException, ClientProtocolException, IOException
	{

		HttpClient httpClient = new DefaultHttpClient();
		URI uri = new URI( "http://192.168.8.185:21088/myspring" );
		HttpGet httpget = new HttpGet( uri );
		HttpResponse httpResponse = httpClient.execute( httpget );
		System.out.println( "状态："+httpResponse.getStatusLine() );
		HttpEntity httpEntity = httpResponse.getEntity();
		if( httpEntity!=null)
		{
			System.out.println( "结果\n"+EntityUtils.toString( httpEntity ) );
		}
		httpClient.getConnectionManager().shutdown();
	}
}
