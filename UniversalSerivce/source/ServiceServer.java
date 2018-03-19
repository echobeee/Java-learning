import java.rmi.*;
@SuppressWarnings("unchecked")
public interface ServiceServer extends Remote {
	Object[] getServiceList() throws RemoteException;
	Service getService(Object serviceKey) throws RemoteException;
} 