package com.amar.wiget.nio.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class CharsetEnDeDemo
{
	public static void main( String args[] ) throws Exception
	{
		Charset latin1 = Charset.forName( "ISO-8859-1" ); // ֻ�ܱ�ʾ��Ӣ���ַ�
		CharsetEncoder encoder = latin1.newEncoder(); // �õ�������
		CharsetDecoder decoder = latin1.newDecoder(); // �õ�������
		// ͨ��CharBuffer���е�
		// CharBuffer cb = CharBuffer.wrap("����MLDN���ʵѵ���ģ�") ;
		CharBuffer cb = CharBuffer.wrap( "����MLDN���ʵѵ���ģ�" );
		
		ByteBuffer buf = encoder.encode( cb ); // ���б������
		System.out.println( decoder.decode( buf ) ); // ���н������
	}
}
