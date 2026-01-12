package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class AtendenteService extends UsuarioService {

    AtendenteDAO atendenteDAO = new AtendenteDAO();

    @Override
    public Usuario criaUsuario(String email, String senha, String nome) {

        Atendente atd = new Atendente(email, senha, nome);
        atendenteDAO.inserir(atd, senha);
        return atd;

    }

    @Override
    public boolean entra(String email, String senha){

        if (!senha.equals(atendenteDAO.localizarPorEmail(email).getEmail())) {
            return false;
        } else {
            return true;
        }

    }

}