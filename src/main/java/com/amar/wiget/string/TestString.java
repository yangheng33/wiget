package com.amar.wiget.string;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
@SuppressWarnings( "unused" )
public class TestString
{

	/**
	 * @param args
	 */
	public static void main( String [] args )
	{
		String sentence = "a '@' The quick brown fox jumped over the lazy dog \n 1";
		
		String sentence2 = " 我的老婆 1 秦善姬";
		
		StringReader reader = new StringReader( sentence );
		int wordCount = 0;
		try
		{
			StreamTokenizer streamTokenizer = new StreamTokenizer( reader );
			
			while ( streamTokenizer.nextToken() != StreamTokenizer.TT_EOF )
			{
				System.out.println(streamTokenizer.ttype );
				if ( streamTokenizer.ttype == StreamTokenizer.TT_WORD )
					wordCount ++ ;
			}

			System.out.println( "Number of words in file: " + wordCount );

		}
		catch ( FileNotFoundException ex )
		{
			ex.printStackTrace();
		}
		catch ( IOException ex )
		{
			ex.printStackTrace();
		}

	}

}
