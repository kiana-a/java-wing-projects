package run.wing;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {

    private static String host = "localhost";

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        MyServices myServices = new MyServicesImpl();
        String rmiObjectString  = "rmi://"+host +"/myServices";
        Naming.rebind(rmiObjectString,myServices);

        System.out.println("Binding Completed ...");
    }
}
