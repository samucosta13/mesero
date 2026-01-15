package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class CentralController {

    private CentralService service = new CentralService();

    public boolean cria(Administrador adm, String nome) {

        try {
            Central central = service.criaCentral(adm, nome);

            return central != null && central.getIdentificador() > 0;

        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean apaga(int identificador) {

        try {
            return service.apagaCentral(identificador);

        } catch(RuntimeException e) {
            return false;
        }
    }

}