package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Saudacao extends Remote {
    String mensagem() throws RemoteException;
    int multiplica(int a, int b) throws RemoteException;
    String getServerIP() throws RemoteException;
    String getClientIP() throws RemoteException;
}
