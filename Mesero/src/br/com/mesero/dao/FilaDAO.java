package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.Central;

public class FilaDAO {

    public void inserir(Central central) {

        String sql = "INSERT INTO fila (id_central) VALUES (?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) { 
            ps.setInt(1, central.getIdentificador());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a fila", e);
        }
    }

}
