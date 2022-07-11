package com.platzi.mensajes;

import java.sql.Connection;

public class Inicio {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        try(Connection cnx = con.getConnection()) {

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
