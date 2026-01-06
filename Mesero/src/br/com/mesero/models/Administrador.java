package br.com.mesero.models;

public class Administrador extends Usuario {
    Administrador(String email, String senha, String nome) {
        super(email, senha, nome);
        this.setIdentificador(1);
    }
}
