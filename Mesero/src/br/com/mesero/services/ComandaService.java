package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class ComandaService {

    ComandaDAO comandaDAO = new ComandaDAO();

    public Comanda criaComanda(int numero, Atendente atendente) {
        Comanda comanda = new Comanda(numero, atendente);
        return comanda;
    }

}