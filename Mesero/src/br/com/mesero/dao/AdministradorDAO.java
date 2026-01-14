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
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) { 
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, senha);

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    administrador.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir administrador", e);
        }
    }

    public boolean deletar(int id) {

        String sql = "DELETE FROM administrador WHERE id_administrador = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int retorno = ps.executeUpdate(); 
            // ps.executeUpdate retorna quantas linhas foram afetadas

            return retorno > 0; // a proposição retorno > 0 pode ser true ou false

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar administrador", e);
        }

    }

    public Administrador localizarPorEmail(String email) {

        String sql = "SELECT id_administrador, nome, email, senha FROM administrador WHERE email = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) { 
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Administrador adm = new Administrador();
                    adm.setIdentificador(rs.getInt("id_administrador"));
                    adm.setNome(rs.getString("nome"));
                    adm.setEmail(rs.getString("email"));
                    adm.setSenha(rs.getString("senha"));
                    return adm;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao localizar administrador", e);
        }

        return null;
    }
}