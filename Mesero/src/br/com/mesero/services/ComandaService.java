package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class ComandaService {

    private ComandaDAO comandaDAO = new ComandaDAO();

    public Comanda criaComanda(int numero, Atendente atendente, Central central) {
        Comanda comanda = new Comanda(numero, atendente);
        comandaDAO.inserir(comanda, central);
        return comanda;
    }

    public boolean apagaComanda(int identificador) {
        return comandaDAO.deletar(identificador);
    }

}