package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class ItemPedidoService {

    ItemPedidoDAO itemDao = new ItemPedidoDAO();

    public ItemPedido criaItemPedido(String nome, Central central) {
        ItemPedido item = new ItemPedido(nome);
        itemDao.inserir(item, central);
        return item;
    }

    public ItemPedido criaItemPedidoComDescricao(String nome, String descricao, Central central) {
        ItemPedido item = new ItemPedido(nome, descricao);
        itemDao.inserir(item, central);
        return item;
    }

}