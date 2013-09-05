package com.amar.wiget.nio.buffer;

import java.nio.IntBuffer;

public class IntBufferDemo02
{
	public static void main( String args[] )
	{
		IntBuffer buf = IntBuffer.allocate( 10 ); // ׼����10����С�Ļ�����
		IntBuffer sub = null; // �����ӻ�����
		for( int i = 0 ; i < 10 ; i ++ )
		{
			buf.put( 2 * i + 1 ); // �����������м���10������
		}

		// ��Ҫͨ��slice() �����ӻ�����
		buf.position( 2 );
		buf.limit( 6 );
		sub = buf.slice();

		for( int i = 0 ; i < sub.capacity() ; i ++ )
		{
			int temp = sub.get( i );
			sub.put( temp - 1 );
		}
		buf.flip(); // ���軺����
		buf.limit( buf.capacity() );
		System.out.print( "���������е����ݣ�" );
		while ( buf.hasRemaining() )
		{
			int x = buf.get();
			System.out.print( x + "��" );
		}
	}
}
