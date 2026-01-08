package br.com.mesero.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Central {
    private int identificador;
    private Administrador administrador;
    private Queue<Pedido> filaDePedidos;
    private List<Comanda> comandas;
    private String nome;

public Central(Administrador administrador, String nome) {
    this.administrador = administrador;
    this.filaDePedidos = new LinkedList<>();
    this.comandas = new ArrayList<>();
    this.nome = nome; 
}

public int getIdentificador() {
    return identificador;
}

public void setIdentificador(int identificador) {
    this.identificador = identificador;
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

public void adicionaComanda(Comanda comanda) {
    this.comandas.add(comanda);
}

public boolean apagaComanda(Comanda comanda) {
    return this.comandas.remove(comanda);
}

public void encaminhaPedido(Pedido pedido) {
    this.filaDePedidos.add(pedido);
}

public boolean cancelaPedido(Pedido pedido) {
    return this.filaDePedidos.remove(pedido);
}

}