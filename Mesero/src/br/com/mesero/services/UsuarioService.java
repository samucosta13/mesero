package br.com.mesero.services;

import br.com.mesero.models.*;

public abstract class UsuarioService {

    public abstract Usuario criaUsuario(String email, String senha, String nome);

    public abstract boolean apagaUsuario(int identificador);

    public abstract boolean entra(String email, String senha);

}