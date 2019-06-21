package run.wing;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by kiana on 12/14/17.
 */
public class MyServicesImpl
        extends UnicastRemoteObject implements MyServices {
    protected MyServicesImpl() throws RemoteException {
    }

    @Override
    public int sum(Data data) throws RemoteException {
        return data.getA() + data.getB();
    }

    @Override
    public int sub(Data data) throws RemoteException {
        return data.getA() - data.getB();
    }
}
