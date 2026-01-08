package br.com.mesero.models;

public class ItemPedidoRegistro {
    private int identificador;
    private Pedido pedido;
    private ItemPedido item;
    private int quantidade;

    public ItemPedidoRegistro(){
    }

    public ItemPedidoRegistro(Pedido pedido, ItemPedido item, int quantidade){
        this.pedido = pedido;
        this.item = item;
        this.quantidade = quantidade;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public ItemPedido getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}