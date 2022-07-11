package com.platzi.mensajes;

import com.platzi.service.MensajeService;

import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("------------------------------");
            System.out.println("Aplicación de Mensajes");
            System.out.println("1. Crear un mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    break;
                case 4:
                    MensajeService.actualizarMensaje();
                    break;
                default:
                    break;
            }
        } while(opcion != 5);
    }
}
