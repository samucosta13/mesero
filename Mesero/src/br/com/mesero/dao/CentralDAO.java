package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class CentralDAO {
    
    public void inserir(Central central) {

        String sql = "INSERT INTO central (nome, id_administrador) VALUES (?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) { 
            ps.setString(1, central.getNome());
            ps.setInt(2, central.getAdministrador().getIdentificador());
            
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    central.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir central", e);
        }
    }
}