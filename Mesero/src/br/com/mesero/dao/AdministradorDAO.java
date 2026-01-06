package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void identificar(Administrador administrador) {

        String sql = "SELECT id_administrador FROM administrador WHERE email = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            ps.setString(1, administrador.getEmail());

            if (rs.next()) {
                administrador.setIdentificador(rs.getInt("id_administrador"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}