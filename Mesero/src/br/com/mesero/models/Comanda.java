package br.com.mesero.models;

import java.util.Queue;

public class Comanda {
    private int numero;
    private Atendente atendente;
    private Queue<Pedido> filaDePedidos;
    private String descricao;

    Comanda(int numero, Atendente atendente) {
        this.numero = numero;
        this.atendente = atendente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void salvaPedido(Pedido pedido) {
        this.filaDePedidos.add(pedido);
    }

    public boolean apagaPedido(Pedido pedido) {
        this.filaDePedidos.remove(pedido);
        return true;
    }
}
