package br.com.mesero.models;

public class ItemPedido {
    private int identificador;
    private String nome;
    private int quantidade;
    private String descricao;

    public ItemPedido(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}