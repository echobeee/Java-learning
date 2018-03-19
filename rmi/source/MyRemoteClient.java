import java.rmi.*;

public class MyRemoteClient {
	public static void main(String[] args) {
		new MyRemoteClient().go();
	}

	public void go() {
		try {
			// lookup() returns type object, so you must cast it to the interface
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");// hostname or  ip / namethat the service was registered under
			String s = service.sayHello(20);

			System.out.println(s);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}