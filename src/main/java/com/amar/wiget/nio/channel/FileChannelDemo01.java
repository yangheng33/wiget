package com.amar.wiget.nio.channel;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.File;
import java.io.FileOutputStream;

public class FileChannelDemo01
{
	public static void main( String args[] ) throws Exception
	{
		String info[] = { "MLDN", "MLDNJAVA", "www.mldn.cn", "www.mldnjava.cn", "���˻�", "lixinghua" };
		File file = new File( "d:" + File.separator + "out.txt" );
		FileOutputStream output = null;
		output = new FileOutputStream( file );
		FileChannel fout = null; // ����FileChannel����
		fout = output.getChannel(); // �õ������ͨ��
		ByteBuffer buf = ByteBuffer.allocate( 1024 );
		for( int i = 0 ; i < info.length ; i ++ )
		{
			buf.put( info[ i ].getBytes() ); // �ַ�����Ϊ�ֽ�����Ž�������֮��
		}
		buf.flip();
		fout.write( buf ); // ���������������
		fout.close();
		output.close();
	}
}
