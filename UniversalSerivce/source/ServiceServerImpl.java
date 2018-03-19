import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
@SuppressWarnings("unchecked")
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
	HashMap serviceList = new HashMap<>();
	
	public ServiceServerImpl() throws RemoteException {
		setUpServices();
	}

	private void setUpServices() {
		serviceList = new HashMap();
		serviceList.put("Dice Rolling Service", new DiceService());
		serviceList.put("Day of the Week Service", new DayOftheWeekService());
		serviceList.put("Visual Music Service", new MiniMusicService());
	}

// get  a list of services to display in the browser
// making the array of just keys , not the actual services
	public Object[] getServiceList() {
		System.out.println("in remote");
		return serviceList.keySet().toArray();
	}

// uses the key to get service out of the HashMap
	public Service getService(Object serviceKey) throws RemoteException {
		Service theService = (Service) serviceList.get(serviceKey);
		return theService;
	}

	public static void main(String[] args) {
		try {
			Naming.rebind("ServiceServer", new ServiceServerImpl());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Remote Service is running");
	}
}