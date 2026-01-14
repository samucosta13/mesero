package br.com.mesero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mesero.database.Database;
import br.com.mesero.models.*;

public class ComandaDAO {

    public void inserir(Comanda comanda, Central central) {

        String sql = "INSERT INTO comanda (numero, descricao, id_central, id_atendente) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, comanda.getNumero());
            ps.setString(2, comanda.getDescricao());
            ps.setInt(3, central.getIdentificador());
            ps.setInt(4, comanda.getAtendente().getIdentificador());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    comanda.setIdentificador(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir comanda", e);
        }
    }

    public boolean deletar(int id) {

        String sql = "DELETE FROM comanda WHERE id_comanda = ?";

        try (
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int retorno = ps.executeUpdate(); 
            // ps.executeUpdate retorna quantas linhas foram afetadas

            return retorno > 0; // a proposição retorno > 0 pode ser true ou false

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar comanda", e);
        }

    }

}