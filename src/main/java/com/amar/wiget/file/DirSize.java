package com.amar.wiget.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirSize
{
	private String logFilePath;

	public static void main( String [] args ) throws IOException
	{
		DirSize dirSize = new DirSize();
		
		//dirSize.countDirSize( "D:\\data\\c\\activemq-cpp-library-3.7.0" , "C:/Users/Administrator/Desktop/qqq.txt" );
		dirSize.countDirSize( "D:\\data\\c\\activemq-cpp-library-3.7.0", "C:/Users/Administrator/Desktop/after2.txt");
	}

	public void countDirSize( String dirPath , String logFilePath ) throws IOException
	{
		this.logFilePath = logFilePath;

		File file = new File( dirPath );

		countDirSizeDetail( file );
	}

	public void countDirSizeDetail( File file ) throws IOException
	{
		if ( file.isDirectory() )
		{
			for( File subfile : file.listFiles() )
			{
				countDirSizeDetail( subfile );
			}
		}
		else
		{
			String log = file.getPath() + "===" + file.length() + "\n";

			writeLog( log );
		}
	}

	public void writeLog( String content )
	{
		try
		{
			System.out.println( content );

			FileWriter writer = new FileWriter( logFilePath , true );

			writer.write( content );
			writer.close();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}
}
