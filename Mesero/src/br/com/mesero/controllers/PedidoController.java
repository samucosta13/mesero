package br.com.mesero.controllers;

import br.com.mesero.models.*;
import br.com.mesero.services.*;

public class PedidoController {

    private PedidoService service = new PedidoService();

    public boolean salva(int mesa, String estado, Comanda comanda) {

        try {
            Pedido pedido = service.salvaPedido(mesa, estado, comanda);

            return pedido != null && pedido.getIdentificador() > 0;

        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean apaga(int identificador) {

        try {
            return service.apagaPedido(identificador);

        } catch(RuntimeException e) {
            return false;
        }
    }

}