package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean deletar(int id) {

        String sql = "DELETE FROM central WHERE id = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int retorno = ps.executeUpdate(); 
            // ps.executeUpdate retorna quantas linhas foram afetadas

            return retorno > 0; // a proposição retorno > 0 pode ser true ou false

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar central", e);
        }

    }

}