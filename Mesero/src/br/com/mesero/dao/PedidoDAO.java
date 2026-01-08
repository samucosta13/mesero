package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class PedidoDAO {

    public void inserir(Pedido pedido, Comanda comanda) {

        String sql = "INSERT INTO pedido (mesa, estado, id_comanda) VALUES (?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, pedido.getMesa());
            ps.setString(2, pedido.getEstado());
            ps.setInt(3, comanda.getIdentificador());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    pedido.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao encaminhar pedido", e);
        }
    }

    // registrarItemPedido (tabela registro)

}