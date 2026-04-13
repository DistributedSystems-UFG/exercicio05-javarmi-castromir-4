package example.hello;

import java.rmi.Naming;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");
        
        String host = (args.length < 1) ? null : args[0];
        try {
            //Registry registry = LocateRegistry.getRegistry(host);
            //System.out.println("Registry has been located");
            //Hello stub = (Hello) registry.lookup("Hello");

            Saudacao stub = (Saudacao) Naming.lookup("rmi://" + host + "/SaudacaoRemota");
            System.out.println("Found server");

            String response = stub.mensagem();
            System.out.println("Response: " + response);

            int result = stub.multiplica(12, 8);
            System.out.println("Response from multiplica: " + result);
            
            String ipServer = stub.getServerIP();
            System.out.println("Server IP: " + ipServer);

            String ipClient = stub.getClientIP();
            System.out.println("Client IP: " + ipClient);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
