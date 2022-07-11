package com.platzi.mensajes;

import com.platzi.modelo.Mensaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    private static final String CREATE_QUERY = "INSERT INTO mensajes_app.mensajes (mensaje, autor_mensaje) VALUES (?,?)";
    private static final String LIST_QUERY  = "SELECT * FROM mensajes_app.mensajes";
    private static final String DELETE_QUERY = "DELETE FROM mensajes_app.mensajes WHERE id_mensaje = ?";
    private static final String UPDATE_QUERY =  "UPDATE mensajes_app.mensajes SET mensaje = ?, autor_mensaje = ?, fecha_mensaje = CURRENT_TIMESTAMP WHERE id_mensaje = ?";

    public static void crearMensajeDB(Mensaje mensaje) {
        Conexion dbConnect = new Conexion();
        PreparedStatement ps;
        try(Connection conexion = dbConnect.getConnection()) {
            try {
                ps = conexion.prepareStatement(CREATE_QUERY);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Message created");
            } catch(SQLException ex) {
                System.out.println("There was an error creating a message " + ex);
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajeDB() {
        Conexion dbConnect = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        try(Connection conexion = dbConnect.getConnection()) {
            ps =  conexion.prepareStatement(LIST_QUERY);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje : " + rs.getString("mensaje"));
                System.out.println("Autor mensaje: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha mensaje: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println("There was an error reading a message " + ex);
        }
    }

    public static void borrarMensajeDB(int idMensaje) {
        Conexion dbConnect = new Conexion();
        PreparedStatement ps;
        try(Connection conexion = dbConnect.getConnection()) {
            ps = conexion.prepareStatement(DELETE_QUERY);
            ps.setInt(1, idMensaje);
            ps.executeUpdate();
            System.out.println("Messsage deleted");
        } catch (SQLException ex) {
            System.out.println("There was an error deleting a message: " + ex);
        }
    }

    public static void actualizarMensaje(Mensaje mensaje) {
        Conexion dbConnect = new Conexion();
        PreparedStatement ps;
        try(Connection conexion = dbConnect.getConnection()) {
            ps = conexion.prepareStatement(UPDATE_QUERY);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutorMensaje());
            ps.setInt(3, mensaje.getIdMensaje());
            ps.executeUpdate();
            System.out.println("Message updated");
        } catch (SQLException ex) {
            System.out.println("There was an error updating a message: " + ex);
        }
    }
}
