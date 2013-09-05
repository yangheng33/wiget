package com.amar.wiget.nio.channel;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class FileChannelDemo02
{
	@SuppressWarnings( "unused" )
	public static void main( String args[] ) throws Exception
	{
		File file1 = new File( "d:" + File.separator + "note.txt" );
		File file2 = new File( "d:" + File.separator + "outnote.txt" );
		FileInputStream input = null;
		FileOutputStream output = null;
		output = new FileOutputStream( file2 );
		input = new FileInputStream( file1 );
		FileChannel fout = null; // ����FileChannel����
		FileChannel fin = null; // ���������ͨ��
		fout = output.getChannel(); // �õ������ͨ��
		fin = input.getChannel(); // �õ������ͨ��
		ByteBuffer buf = ByteBuffer.allocate( 1024 );

		int temp = 0;
		while ( ( temp = fin.read( buf ) ) != - 1 )
		{
			buf.flip();
			fout.write( buf );
			buf.clear(); // ��ջ�����,���е�״̬������λ�ûָ���ԭ��
		}
		fin.close();
		fout.close();
		input.close();
		output.close();
	}
}
