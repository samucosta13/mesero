package br.com.mesero.models;

/*
Model → regras que dizem como o objeto se comporta
Service → regras que dizem o que acontece em um caso de uso
*/

public class Usuario {

    private int identificador;
    private String email;
    private String senha;
    private String nome;
    
    public Usuario() {
    }

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void identificar(int id) {
        this.identificador = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}