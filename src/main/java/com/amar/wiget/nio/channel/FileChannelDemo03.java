package com.amar.wiget.nio.channel;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.io.File;
import java.io.FileInputStream;

public class FileChannelDemo03
{
	public static void main( String args[] ) throws Exception
	{
		File file = new File( "d:" + File.separator + "mldn.txt" );
		FileInputStream input = null;
		input = new FileInputStream( file );
		FileChannel fin = null; // ���������ͨ��
		fin = input.getChannel(); // �õ������ͨ��
		MappedByteBuffer mbb = null;
		mbb = fin.map( FileChannel.MapMode.READ_ONLY , 0 , file.length() );
		byte data[] = new byte [ ( int ) file.length() ]; // ���ٿռ��������
		int foot = 0;
		while ( mbb.hasRemaining() )
		{
			data[ foot ++ ] = mbb.get(); // ��ȡ����
		}
		System.out.println( new String( data ) ); // �������
		fin.close();
		input.close();
	}
}
