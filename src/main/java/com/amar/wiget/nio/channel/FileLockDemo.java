package com.amar.wiget.nio.channel;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo
{
	public static void main( String args[] ) throws Exception
	{
		File file = new File( "d:" + File.separator + "mldn.txt" );
		FileOutputStream output = null;
		output = new FileOutputStream( file , true );
		FileChannel fout = null;
		fout = output.getChannel();// �õ�ͨ��
		FileLock lock = fout.tryLock(); // ���ж�ռ���Ĳ���
		if ( lock != null )
		{
			System.out.println( file.getName() + "�ļ�����300��" );
			Thread.sleep( 300000 );
			lock.release(); // �ͷ�
			System.out.println( file.getName() + "�ļ����������" );
		}
		fout.close();
		output.close();
	}

}
