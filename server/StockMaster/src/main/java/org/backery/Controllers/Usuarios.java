package org.backery.Controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    Scanner lector = new Scanner(System.in);
    ArrayList<String> list_usuario = new ArrayList<String>();
    ArrayList<String> list_contrasena = new ArrayList<String>();
    ArrayList<String> list_nombres = new ArrayList<String>();
    ArrayList<String> list_correos = new ArrayList<String>();
    String usuario = "", contraseña = "", agregarusuario = "", agregarcontra = "", sesion = "", agregarnombre = "", agregarcorreo = "";
    public void login() {
        //creamos cuenta admin como default
        list_usuario.add("admin");
        list_contrasena.add("admin");

        //obtenemos info
        System.out.println("Escribe tu usuario y contraseña para iniciar sesion");
        System.out.print("Usuario: ");
        usuario = lector.next();
        System.out.println();
        System.out.print("Contraseña: ");
        contraseña = lector.next();
        sesion = usuario;
    }
    public void agregar_Usuario() {
        System.out.println("Escribe el nombre de la persona");
        System.out.print("Nombre: ");
        agregarnombre = lector.next();

        System.out.println("Escribe el correo electronico de la persona");
        System.out.print("Correo:");
        agregarcorreo = lector.next();

        System.out.println("Escribe el nombre de usuario que deseas agregar");
        System.out.print("Usuario: ");
        agregarusuario = lector.next();

        System.out.println("Escribe una contraseña para el usuario");
        System.out.print("Contraseña:");
        agregarcontra = lector.next();

        list_usuario.add(agregarusuario);
        list_contrasena.add(agregarcontra);
        list_nombres.add(agregarnombre);
        list_correos.add(agregarcorreo);

        System.out.println("Usuario agregado!");
    }
}