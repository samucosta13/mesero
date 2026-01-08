package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class PedidoDAO {

    public void inserir(Pedido pedido, Atendente atendente) {

        String sql = "INSERT INTO pedido (mesa, id_atendente) VALUES (?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, pedido.getMesa());
            ps.setInt(2, atendente.getIdentificador());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    pedido.setNumero(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao encaminhar pedido", e);
        }
    }

    // registrarItemPedido (tabela registro)

    // encaminharPedido (tabela pedido, coluna id_fila)

}