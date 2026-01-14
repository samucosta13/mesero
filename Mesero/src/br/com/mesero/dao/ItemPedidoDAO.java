package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class ItemPedidoDAO {

    public void inserir(ItemPedido itemPedido, Central central) {

        String sql = "INSERT INTO item_pedido (nome, descricao, id_central) VALUES (?, ?, ?)";

            try (
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                sql, PreparedStatement.RETURN_GENERATED_KEYS)
            ) { 
                ps.setString(1, itemPedido.getNome());
                ps.setString(2, itemPedido.getDescricao());
                ps.setInt(3, central.getIdentificador());

                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        itemPedido.setIdentificador(rs.getInt(1));
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao cadastrar item", e);
            }

        }

    public boolean deletar(int id) {

        String sql = "DELETE FROM item_pedido WHERE id_item_pedido = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int retorno = ps.executeUpdate(); 
            // ps.executeUpdate retorna quantas linhas foram afetadas

            return retorno > 0; // a proposição retorno > 0 pode ser true ou false

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar item", e);
        }

    }

}