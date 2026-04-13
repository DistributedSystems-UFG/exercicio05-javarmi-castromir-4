package example.livro;

import java.io.Serializable;

public class Livro implements Serializable {
    private String titulo;
    private int ano;

    public Livro(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "{titulo='" + titulo + "', ano=" + ano + "}";
    }
}
