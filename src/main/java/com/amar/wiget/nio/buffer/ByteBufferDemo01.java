package com.amar.wiget.nio.buffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo01
{
	public static void main( String args[] )
	{
		ByteBuffer buf = ByteBuffer.allocateDirect( 10 ); // ׼����10����С�Ļ�����
		byte temp[] = { 1, 3, 5, 7, 9 }; // ��������
		buf.put( temp ); // ����һ������
		buf.flip();

		System.out.print( "���������е����ݣ�" );
		while ( buf.hasRemaining() )
		{
			int x = buf.get();
			System.out.print( x + "��" );
		}
	}
}
