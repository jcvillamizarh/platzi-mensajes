package com.platzi.service;

import com.platzi.mensajes.MensajeDAO;
import com.platzi.modelo.Mensaje;
import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe el nombre del autor del mensaje: ");
        String autorMensaje = sc.nextLine();
        Mensaje ms = new Mensaje();
        ms.setMensaje(mensaje);
        ms.setAutorMensaje(autorMensaje);
        MensajeDAO.crearMensajeDB(ms);
    }

    public static void listarMensajes(){
        MensajeDAO.leerMensajeDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id del mensaje a borrar");
        int idMensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(idMensaje);
    }

    public static void actualizarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el mensaje a actualizar");
        String mensaje = sc.nextLine();
        System.out.println("Digite el autor a Actualizar");
        String autor = sc.nextLine();
        System.out.println("Digite el id del mensaje a actualizar");
        int mensajeId = sc.nextInt();
        Mensaje ms = new Mensaje();
        ms.setIdMensaje(mensajeId);
        ms.setMensaje(mensaje);
        ms.setAutorMensaje(autor);
        MensajeDAO.actualizarMensaje(ms);
    }
}
