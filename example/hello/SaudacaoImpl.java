package example.hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SaudacaoImpl extends UnicastRemoteObject implements Saudacao {

    public SaudacaoImpl(int port) throws RemoteException {
        super(port);
    }

    public String mensagem() throws RemoteException {
        return "Olá! Objeto remoto respondendo.";
    }

    public int multiplica(int a, int b) throws RemoteException {
        return a * b;
    }

    public String getServerIP() throws RemoteException {
        String ip;
        try {
            ip = java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            System.err.println("Error getting server IP: " + e.toString());
            e.printStackTrace();
            ip = "";
        }
        return ip;
    }

    public String getClientIP() throws RemoteException {
        String clientIP = "";
        try {
            clientIP = java.rmi.server.RemoteServer.getClientHost();
        } catch (Exception e) {
            System.err.println("Error getting client IP: " + e.toString());
            e.printStackTrace();
        }
        return clientIP;
    }
}
