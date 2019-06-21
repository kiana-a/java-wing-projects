package run.wing;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by kiana on 12/14/17.
 */
public interface MyServices extends Remote {
    int sum (Data data) throws RemoteException;
    int sub (Data data) throws RemoteException;
}
