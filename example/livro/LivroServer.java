package example.livro;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LivroServer extends UnicastRemoteObject implements LivroService {
    protected LivroServer(int port) throws RemoteException {
        super(port);
    }

    @Override
    public Livro cadastrarLivro(String titulo, int ano) throws RemoteException {
        Livro l = new Livro(titulo, ano);
        System.out.println("Livro cadastrado: " + l);
        return l;
    }

    public static void main(String[] args) {
        try {
            String hostname = System.getProperty("java.rmi.server.hostname");
            if (hostname != null) {
                System.err.println("Binding RMI server to hostname: " + hostname);
            }
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            LivroServer server = new LivroServer(5678);
            Naming.rebind("LivroService", server);
            System.err.println("LivroServer ready");
        } catch (Exception e) {
            System.err.println("LivroServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
