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
		Charset latin1 = Charset.forName( "ISO-8859-1" ); // 只能表示的英文字符
		CharsetEncoder encoder = latin1.newEncoder(); // 得到编码器
		CharsetDecoder decoder = latin1.newDecoder(); // 得到解码器
		// 通过CharBuffer类中的
		// CharBuffer cb = CharBuffer.wrap("北京MLDN软件实训中心！") ;
		CharBuffer cb = CharBuffer.wrap( "北京MLDN软件实训中心！" );
		
		ByteBuffer buf = encoder.encode( cb ); // 进行编码操作
		System.out.println( decoder.decode( buf ) ); // 进行解码操作
	}
}
