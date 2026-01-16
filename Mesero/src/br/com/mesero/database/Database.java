package br.com.mesero.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL =
    "jdbc:mysql://mysql:3306/mesero" +
    "?useSSL=false" +
    "&serverTimezone=UTC" +
    "&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "senha123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}