package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class ItemPedidoRegistroDAO {

    public void inserir(ItemPedidoRegistro itemPedidoRegistro) {

        String sql = "INSERT INTO registro (id_pedido, id_item_pedido, quantidade) VALUES (?, ?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) { 
            ps.setInt(1, itemPedidoRegistro.getPedido().getIdentificador());
            ps.setInt(2, itemPedidoRegistro.getItem().getIdentificador());
            ps.setInt(3, itemPedidoRegistro.getQuantidade());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    itemPedidoRegistro.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar item de pedido", e);
        }
    }

    public boolean deletar(int id) {

        String sql = "DELETE FROM registro WHERE id = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int retorno = ps.executeUpdate(); 
            // ps.executeUpdate retorna quantas linhas foram afetadas

            return retorno > 0; // a proposição retorno > 0 pode ser true ou false

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar registro de item", e);
        }

    }
}