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
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) { 
            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getEmail());
            ps.setString(3, senha);

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    atendente.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir atendente", e);
        }
    }

    public Atendente localizarPorEmail(String email) {

        String sql = "SELECT id_atendente, nome, email, senha FROM atendente WHERE email = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) { 
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Atendente atd = new Atendente();
                    atd.setIdentificador(rs.getInt("id_atendente"));
                    atd.setNome(rs.getString("nome"));
                    atd.setEmail(rs.getString("email"));
                    atd.setSenha(rs.getString("senha"));
                    return atd;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao localizar atendente", e);
        }

        return null;
    }

}