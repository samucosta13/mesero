package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class ItemPedidoRegistroController {

    private ItemPedidoRegistroService service = new ItemPedidoRegistroService();

    public boolean salva(Pedido pedido, ItemPedido item, int quantidade) {

        try {
            ItemPedidoRegistro registro = service.anotaItemPedido(pedido, item, quantidade);

            return registro != null && registro.getIdentificador() > 0;

        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean apaga(int identificador) {

        try {
            return service.apagaRegistro(identificador);

        } catch(RuntimeException e) {
            return false;
        }
    }

}