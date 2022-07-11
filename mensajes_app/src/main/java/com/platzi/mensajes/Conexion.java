package com.platzi.mensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/mensajes_app";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);

        } catch(SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
