package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class ComandaDAO {

    public void inserir(Comanda comanda, Central central, Atendente atendente) {

        String sql = "INSERT INTO comanda (numero, descricao, id_central, id_atendente) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, comanda.getNumero());
            ps.setString(2, comanda.getDescricao());
            ps.setInt(3, central.getIdentificador());
            ps.setInt(4, atendente.getIdentificador());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    comanda.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar item", e);
        }
    }

}