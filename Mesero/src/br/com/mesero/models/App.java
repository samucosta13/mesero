package br.com.mesero.models;

import br.com.mesero.controllers.*;

/*
Model → representa o domínio
DAO → persiste objetos
Service → aplica regras
*/

public class App {

    public static void main(String[] args) {

        // Controllers
        AdministradorController admController = new AdministradorController();
        AtendenteController atdController = new AtendenteController();
        CentralController centralController = new CentralController();
        ComandaController comandaController = new ComandaController();
        PedidoController pedidoController = new PedidoController();
        ItemPedidoController itemController = new ItemPedidoController();
        ItemPedidoRegistroController registroController = new ItemPedidoRegistroController();

        // 1️⃣ Criar administrador
        admController.cadastra("admin@mesero.com", "123", "Administrador");

        // Login (opcional)
        admController.entra("admin@mesero.com", "123");

        // 2️⃣ Criar atendente
        atdController.cadastra("atendente@mesero.com", "123", "Atendente");

        // 3️⃣ Recuperar objetos (normalmente viria de DAO find)
        Administrador adm = new Administrador();
        adm.setIdentificador(1);

        Atendente atd = new Atendente();
        atd.setIdentificador(1);

        // 4️⃣ Criar central
        centralController.cria(adm, "Central Principal");

        Central central = new Central();
        central.setIdentificador(1);

        // 5️⃣ Criar comanda
        comandaController.cria(100, atd, central);

        Comanda comanda = new Comanda();
        comanda.setIdentificador(1);

        // 6️⃣ Criar pedido
        pedidoController.salva(10, "ABERTO", comanda);

        Pedido pedido = new Pedido();
        pedido.setIdentificador(1);

        // 7️⃣ Criar item de pedido
        itemController.cria("Hambúrguer", central);

        ItemPedido item = new ItemPedido();
        item.setIdentificador(1);

        // 8️⃣ Registrar item no pedido
        registroController.salva(pedido, item, 2);

        System.out.println("Fluxo completo executado com sucesso!");
    }

}