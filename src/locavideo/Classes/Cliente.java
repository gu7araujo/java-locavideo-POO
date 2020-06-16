package locavideo.Classes;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private String nome;
    private String cpf;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
