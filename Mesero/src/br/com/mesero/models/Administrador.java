package br.com.mesero.models;

public class Administrador extends Usuario {

    public Administrador() {
        super();
    }
    
    public Administrador(String email, String senha, String nome) {
        super(email, senha, nome);
    }
}