package run.wing;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
//        MyServices myServices = (MyServices) Naming.lookup("rmi://localhost/myServices");
        System.setProperty("java.security.policy","file:///home/kiana/IdeaProjects/RMI_Client/client.policy");
        System.setProperty("java.rmi.server.hostname","192.168.100.30");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String serverIP = "192.168.100.30";
        int serverPort = 1099;
        Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
        MyServices myServices = (MyServices) registry.lookup("rmi://192.168.100.30/myServices");
        System.out.println(myServices.sub(new Data(4, 6)));
        System.out.println(myServices.sum(new Data(7, 1)));
    }
}
