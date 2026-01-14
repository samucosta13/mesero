package br.com.mesero.services;

import br.com.mesero.dao.*;
import br.com.mesero.models.*;

public class PedidoService {

    PedidoDAO pedidoDAO = new PedidoDAO();

    public Pedido salvaPedido(int mesa, String estado, Comanda comanda) {
        Pedido pedido = new Pedido(mesa, estado);
        pedidoDAO.inserir(pedido, comanda);
        return pedido;
    }

}