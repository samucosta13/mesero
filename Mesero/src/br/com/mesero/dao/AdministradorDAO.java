package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class AdministradorDAO {

    public void inserir(Administrador administrador, String senha) {

        String sql = "INSERT INTO administrador (nome, email, senha) VALUES (?, ?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) { 
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, senha);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir administrador", e);
        }
    }

    public int buscarIdPorEmail(String email) {

        String sql = "SELECT id_administrador FROM administrador WHERE email = ?";
        int id = -1;

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_administrador");
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar administrador por email", e);
        }

        return id;
    }

}