package example.livro;

import java.rmi.Naming;

public class LivroClient {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java LivroClient <host> -t {titulo} -y {ano}");
            return;
        }
        String host = args[0];
        String titulo = null;
        int ano = -1;
        for (int i = 1; i < args.length; i++) {
            if ("-t".equals(args[i]) && i + 1 < args.length) {
                titulo = args[++i];
            } else if ("-y".equals(args[i]) && i + 1 < args.length) {
                try {
                    ano = Integer.parseInt(args[++i]);
                } catch (NumberFormatException e) {
                    System.err.println("Ano inválido: " + args[i]);
                    return;
                }
            }
        }
        if (titulo == null || ano < 0) {
            System.out.println("Uso: java LivroClient <host> -t {titulo} -y {ano}");
            return;
        }
        try {
            String url = "rmi://" + host + "/LivroService";
            LivroService service = (LivroService) Naming.lookup(url);
            Livro l = service.cadastrarLivro(titulo, ano);
            System.out.println("Received from server: " + l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
