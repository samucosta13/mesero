package br.com.mesero.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int numero;
    private int mesa;
    private String estado;
    private Date dataRegistro;
    private List<ItemPedido> itens;

    public Pedido(int mesa, String estado) {
        this.mesa = mesa;
        this.estado = estado;
        this.dataRegistro = new Date();
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionaItem(ItemPedido itemNovo) {
        this.itens.add(itemNovo);
        this.dataRegistro = new Date();
    }

    public void removeItem(ItemPedido itemNovo) {
        this.itens.remove(itemNovo);
        this.dataRegistro = new Date();
    }
}
