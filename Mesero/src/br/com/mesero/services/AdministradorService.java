package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class AdministradorService extends UsuarioService {

    AdministradorDAO administradorDao = new AdministradorDAO();

    @Override
    public Usuario criaUsuario(String email, String senha, String nome) {

        Administrador adm = new Administrador(email, senha, nome);
        administradorDao.inserir(adm, senha);
        return adm;

    }

    @Override
    public boolean entra(String email, String senha){

        if (!senha.equals(administradorDao.localizarPorEmail(email).getEmail())) {
            return false;
        } else {
            return true;
        }

    }

}