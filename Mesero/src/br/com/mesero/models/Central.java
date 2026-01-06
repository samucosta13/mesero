package br.com.mesero.models;

import java.util.List;
import java.util.Queue;

public class Central {
    private Administrador administrador;
    private Queue<Pedido> filaDePedidos;
    private List<Comanda> comandas;
    private String nome;

Central(Administrador administrador, String nome) {
    this.administrador = administrador;
    this.nome = nome;
}

public Administrador getAdministrador() {
    return administrador;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public void criaComanda(int numero, Atendente atendente) {
    Comanda comanda = new Comanda(numero, atendente);
    this.comandas.add(comanda);
}

public boolean apagaComanda(Comanda comanda) {
    this.comandas.remove(comanda);
    return true;
}

public void encaminhaPedido(Pedido pedido) {
    this.filaDePedidos.add(pedido);
}

public boolean cancelaPedido(Pedido pedido) {
    this.filaDePedidos.remove(pedido);
    return true;
}

public void cadastraItemPedido(String nome) {
    // Inclusão no cardápio (tabela item_pedido)
}

public void apagaItemPedido(ItemPedido itemPedido) {
    // Exclusão do cardápio (tabela item_pedido)
}

}