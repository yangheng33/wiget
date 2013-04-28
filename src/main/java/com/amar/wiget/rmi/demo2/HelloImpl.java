package com.amar.wiget.rmi.demo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

	public static final long serialVersionUID = 10213123L;

	public HelloImpl() throws RemoteException {
	}

	public String helloWorld() throws RemoteException {
		return "Hello World!";
	}

	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException {
		return "你好," + someBodyName + "!";
	}
}