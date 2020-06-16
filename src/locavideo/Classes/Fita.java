
package locavideo.Classes;

import java.io.Serializable;

public class Fita implements Serializable {
    private String nome;
    private String genero;
    private String categoria; 

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public Fita(String nome, String genero, String categoria){
        this.nome = nome;
        this.genero = genero;
        this.categoria = categoria;
    }
}
