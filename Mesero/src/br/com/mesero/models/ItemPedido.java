package br.com.mesero.models;

public class ItemPedido {
    private int identificador;
    private String nome;
    private String descricao;

    public ItemPedido() {
    }

    public ItemPedido(String nome) {
        this.nome = nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}