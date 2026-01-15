package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class ComandaController {

    private ComandaService service = new ComandaService();

    public boolean cria(int numero, Atendente atendente, Central central) {

        try {
            Comanda comanda = service.criaComanda(numero, atendente, central);

            return comanda != null && comanda.getIdentificador() > 0;

        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean apaga(int identificador) {

        try {
            return service.apagaComanda(identificador);

        } catch(RuntimeException e) {
            return false;
        }
    }

}