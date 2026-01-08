package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class AtendenteDAO {

    public void inserir(Atendente atendente, String senha) {

        String sql = "INSERT INTO atendente (nome, email, senha) VALUES (?, ?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) { 
            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getEmail());
            ps.setString(3, senha);
            
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir atendente", e);
        }
    }

    public int buscarIdPorEmail(String email) {

        String sql = "SELECT id_atendente FROM atendente WHERE email = ?";
        int id = -1;

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_atendente");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar atendente por email", e);
        }

        return id;
    }

}