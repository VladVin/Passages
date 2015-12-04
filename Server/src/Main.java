import Interfaces.IServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    private static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        String serverName = "Server";
        IServer server = null;
        try {
            server = new Server();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            IServer stub = (IServer) UnicastRemoteObject.exportObject(server, 55555);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(serverName, stub);
            System.out.println("Server stub bound");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
