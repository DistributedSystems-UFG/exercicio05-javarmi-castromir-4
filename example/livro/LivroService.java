package example.livro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LivroService extends Remote {
    Livro cadastrarLivro(String titulo, int ano) throws RemoteException;
}
