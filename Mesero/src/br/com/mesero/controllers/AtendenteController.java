package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class AtendenteController {

    private AtendenteService service = new AtendenteService();

    public boolean cadastra(String email, String senha, String nome) {

        try {
            Usuario atd = service.criaUsuario(email, senha, nome);

            return atd != null && atd.getIdentificador() > 0;

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