package com.amar.wiget.nio.buffer;

import java.nio.IntBuffer;

public class IntBufferDemo01
{
	public static void main( String args[] )
	{
		IntBuffer buf = IntBuffer.allocate( 10 ); // ׼����10����С�Ļ�����
		
		System.out.print( "1��д������֮ǰ��position��limit��capacity��" );
		System.out.println( "position = " + buf.position() + "��limit = " + buf.limit() + "��capacty = " + buf.capacity() );
		int temp[] = { 5, 7, 9 };// ����һ��int����
		buf.put( 3 ); // ����һ������
		buf.put( temp ); // ��ʱ�Ѿ�������ĸ���¼
		System.out.print( "2��д������֮���position��limit��capacity��" );
		System.out.println( "position = " + buf.position() + "��limit = " + buf.limit() + "��capacty = " + buf.capacity() );

		buf.flip(); // ���軺����
		// postion = 0 ,limit = ԭ��position
		System.out.print( "3��׼���������ʱ��position��limit��capacity��" );
		System.out.println( "position = " + buf.position() + "��limit = " + buf.limit() + "��capacty = " + buf.capacity() );
		System.out.print( "�������е����ݣ�" );
		while ( buf.hasRemaining() )
		{
			int x = buf.get();
			System.out.print( x + "��" );
		}
	}
}
