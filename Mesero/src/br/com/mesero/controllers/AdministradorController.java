package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class AdministradorController {

    private AdministradorService service = new AdministradorService();

    public boolean cadastra(String email, String senha, String nome) {

        try {
            Usuario adm = service.criaUsuario(email, senha, nome);

            // proposição que resultará em true ou false
            return adm != null && adm.getIdentificador() > 0;

        } catch(RuntimeException e) {
            return false;
        }
    }

    public boolean entra(String email, String senha) {

        try {
            return service.entra(email, senha);

        } catch(RuntimeException e) {
            return false;
        }
    }

    public boolean apaga(int identificador) {

        try {
            return service.apagaUsuario(identificador);
        } catch(RuntimeException e) {
            return false;
        }
    }

}