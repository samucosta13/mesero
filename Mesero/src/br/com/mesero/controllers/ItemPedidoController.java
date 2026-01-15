package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class ItemPedidoController {

    private ItemPedidoService service = new ItemPedidoService();

    public boolean cria(String nome, Central central) {

        try {
            ItemPedido item = service.criaItemPedido(nome, central);

            return item != null && item.getIdentificador() > 0;

        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean apaga(int identificador) {

        try {
            return service.apagaItemPedido(identificador);

        } catch(RuntimeException e) {
            return false;
        }
    }

}