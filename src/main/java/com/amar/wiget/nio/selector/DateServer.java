package com.amar.wiget.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Set;
import java.util.Iterator;
import java.util.Date;
import java.nio.channels.ServerSocketChannel;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;

public class DateServer
{
	@SuppressWarnings( "unused" )
	public static void main( String args[] ) throws Exception
	{
		int ports[] = { 8000, 8001, 8002, 8003, 8005, 8006 }; // ��ʾ��������˿�
		Selector selector = Selector.open(); // ͨ��open()�����ҵ�Selector
		for( int i = 0 ; i < ports.length ; i ++ )
		{
			ServerSocketChannel initSer = null;
			initSer = ServerSocketChannel.open(); // �򿪷�������ͨ��
			initSer.configureBlocking( false ); // ����������Ϊ������
			ServerSocket initSock = initSer.socket();
			InetSocketAddress address = null;
			address = new InetSocketAddress( ports[ i ] ); // ʵ�����󶨵�ַ
			initSock.bind( address ); // ���з���İ�
			initSer.register( selector , SelectionKey.OP_ACCEPT ); // �ȴ�����
			System.out.println( "���������У���" + ports[ i ] + "�˿ڼ�����" );
		}
		// Ҫ����ȫ�����ɵ�key����ͨ�����ӽ����ж��Ƿ��ȡ�ͻ��˵����
		
		int keysAdd = 0;
		while ( ( keysAdd = selector.select() ) > 0 )
		{ // ѡ��һ�����������Ӧ��ͨ���Ѿ�׼������
			Set<SelectionKey> selectedKeys = selector.selectedKeys();// ȡ��ȫ�����ɵ�key
			Iterator<SelectionKey> iter = selectedKeys.iterator();
			while ( iter.hasNext() )
			{
				SelectionKey key = iter.next(); // ȡ��ÿһ��key
				if ( key.isAcceptable() )
				{
					ServerSocketChannel server = ( ServerSocketChannel ) key.channel();
					SocketChannel client = server.accept(); // ����������
					client.configureBlocking( false );// ����Ϊ������
					ByteBuffer outBuf = ByteBuffer.allocateDirect( 1024 ); //
					outBuf.put( ( "��ǰ��ʱ��Ϊ��" + new Date() ).getBytes() ); // �򻺳�������������
					outBuf.flip();
					client.write( outBuf ); // �������
					client.close(); // �ر�
				}
			}
			selectedKeys.clear(); // ���ȫ����key
		}

	}
}
