package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class CentralService {

    CentralDAO centralDAO = new CentralDAO();

    public Central criaCentral(Administrador adm, String nome) {
        Central central = new Central(adm, nome);
        centralDAO.inserir(central);
        return central;
    }

    public boolean apagaCentral(int identificador) {
        return centralDAO.deletar(identificador);
    }

}