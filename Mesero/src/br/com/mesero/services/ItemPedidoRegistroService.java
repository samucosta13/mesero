package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class ItemPedidoRegistroService {

    ItemPedidoRegistroDAO registroDAO = new ItemPedidoRegistroDAO();

    public ItemPedidoRegistro anotaItemPedido(Pedido pedido, ItemPedido item, int quantidade) {
        ItemPedidoRegistro registro = new ItemPedidoRegistro(pedido, item, quantidade);
        registroDAO.inserir(registro);
        return registro;
    }

    public boolean apagaRegistro(int identificador) {
        return registroDAO.deletar(identificador);
    }

}