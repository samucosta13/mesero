package br.com.mesero.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int identificador;
    private int mesa;
    private String estado;
    private List<ItemPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(int mesa, String estado) {
        this.mesa = mesa;
        this.estado = estado;
        this.itens = new ArrayList<>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionaItem(ItemPedido itemNovo) {
        this.itens.add(itemNovo);
    }

    public void removeItem(ItemPedido itemNovo) {
        this.itens.remove(itemNovo);
    }
}