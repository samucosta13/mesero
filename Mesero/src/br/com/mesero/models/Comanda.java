package br.com.mesero.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Comanda {
    private int identificador;
    private int numero;
    private Atendente atendente;
    private Queue<Pedido> filaDePedidos;
    private String descricao;

    Comanda(int numero, Atendente atendente) {
        this.numero = numero;
        this.atendente = atendente;
        this.filaDePedidos = new LinkedList<>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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