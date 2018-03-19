/*
	making the remote service
	1. make remote interface -> defines the remote methods that  u want clients to call
	2. make a remote implmentation -> the real service, implements the method that do the real work
	3. generate the stubs using rmic -> in classpath(impl class), cmd : rmic [className]
	4. start the RMI registry -> cmd : rmiregistry
	5. start the remote service -> java [className]
 */

import java.rmi.*;
import java.rmi.server.*; // unicastRemoteObject

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{ //MUST implement my remote interface!

// You have to implement  all the interface method.
// But don't have to declare RemoteException
	public String sayHello(int num) {
		return "Server says, 'Hey'" + num*20 ;
	}

// superclass constructor declares an exception,so u should too
	public MyRemoteImpl() throws RemoteException{ 
		super();
	}

	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service); // give service a name, and then register it with RMI registry
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
