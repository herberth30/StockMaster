package org.backery.Controllers;

import org.backery.Model.Entities.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Scanner;

//import static org.example.Main.prodControl;

@RestController
public class UsuariosController {
    Usuario usuario = new Usuario();
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public Usuarios usuarios = new Usuarios();
    /*public void dispatch_revisar() {
        boolean revisar_usuario = usuarios.list_usuario.contains(usuarios.usuario), revisar_contra = usuarios.list_contrasena.contains(usuarios.contraseña);

        if (revisar_usuario & revisar_contra) {
            if (usuarios.sesion.equals("admin")) {
                usuarios.agregar_Usuario();
                usuarios.login();
            }
            prodControl();
        } else {
            System.out.println("El usuario o contraseña estan incorrectos, o no existen");
        }
    }*/
    @GetMapping(value = "/wellcome") //ruta http://localhost:9090/wellcome
    public Usuario sayHello(){

        usuario.setName("moises");
        usuario.setUsername("alx7770i535");
        usuario.setEmail("alx7770i535@gamil.com");
        usuario.setPassword("1234abc");
//        return "hello world!";
        return usuario;
    }
    public void dispatch_login() {
        usuarios.login();
    }

    public void register(String nombre, String correo, String usuario, String contrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsername().equals(usuario)) {
                System.out.println("El usuario ya existe");
                return;
            }
        }
        listaUsuarios.add(new Usuario(nombre, correo, usuario, contrasena));
        System.out.println("Usuario registrado");
    }

    public void login(String usuario, String contrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsername().equals(usuario) && u.getPassword().equals(contrasena)) {
                System.out.println("Bienvenido " + u.getName());

                prodControl();

                return;
            }
        }
        System.out.println("El usuario o contraseña estan incorrectos, o no existen");

    }

    public static void prodControl(){
        Scanner scan = new Scanner(System.in);
        ProductoController productoController = new ProductoController();
        int opcion = 0;
        String nombre;
        int cantidad;
        while(true) {
            System.out.println("Bienvenido al sistema de almacen");
            System.out.println("1. Crear producto");
            System.out.println("2. Abastecer producto");
            System.out.println("3. Vender producto");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Mostrar ingresos");
            System.out.println("6. Mostrar ventas");
            System.out.println("7. Salir");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1 -> {
                    scan.nextLine();
                    System.out.println("Creando producto");
                    System.out.println("Ingrese el nombre del producto");
                    nombre = scan.nextLine();
                    System.out.println("Ingrese cantidad de producto");
                    cantidad = scan.nextInt();
                    productoController.crearProducto(nombre, cantidad);
                }
                case 2 -> {
                    scan.nextLine();
                    System.out.println("Abasteciendo producto");
                    System.out.println("Ingrese el nombre del producto");
                    nombre = scan.nextLine();
                    System.out.println("Ingrese cantidad de producto");
                    cantidad = scan.nextInt();
                    productoController.abastecerProducto(nombre, cantidad);
                }
                case 3 -> {
                    scan.nextLine();
                    System.out.println("Vendiendo producto");
                    System.out.println("Ingrese el nombre del producto");
                    nombre = scan.nextLine();
                    System.out.println("Ingrese cantidad de producto");
                    cantidad = scan.nextInt();
                    productoController.venderProducto(nombre, cantidad);
                }
                case 4 -> productoController.mostrarProductos();
                case 5 -> productoController.mostrarIngresos();
                case 6 -> productoController.mostrarVentas();
                case 7 -> {
                    System.out.println("Saliendo del sistema");
                    return;
                }

                default -> System.out.println("Opcion no valida");
            }
        }
    }
}
