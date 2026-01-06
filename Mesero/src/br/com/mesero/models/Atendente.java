package br.com.mesero.models;

public class Atendente extends Usuario {

    public Atendente() {
        super();
    }
    
    public Atendente(String email, String senha, String nome) {
        super(email, senha, nome);
        this.setIdentificador(2);
    }
}
