import  java.rmi.*;

// make a remote interface
// be sure arguments and return values are serializable 
public interface  MyRemote extends Remote { // THIS IS A INTERFACE! SO IS Remote!
	public String sayHello(int num) throws RemoteException; // every method MUST thorws RemoteException
}