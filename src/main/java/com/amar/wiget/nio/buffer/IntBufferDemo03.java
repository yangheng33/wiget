package com.amar.wiget.nio.buffer;

import java.nio.IntBuffer;

public class IntBufferDemo03
{
	public static void main( String args[] )
	{
		IntBuffer buf = IntBuffer.allocate( 10 ); // ׼����10����С�Ļ�����
		IntBuffer read = null; // �����ӻ�����
		for( int i = 0 ; i < 10 ; i ++ )
		{
			buf.put( 2 * i + 1 ); // �����������м���10������
		}
		read = buf.asReadOnlyBuffer();// ����ֻ��������

		read.flip(); // ���軺����
		System.out.print( "���������е����ݣ�" );
		while ( read.hasRemaining() )
		{
			int x = read.get();
			System.out.print( x + "��" );
		}
		read.put( 30 ); // �޸ģ�����
	}
}
