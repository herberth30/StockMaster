package org.backery.Controllers;
import org.backery.Model.Entities.Almacen;
import org.backery.Model.Entities.Ingreso;
import org.backery.Model.Entities.Venta;

import java.util.ArrayList;

public class ProductoController {
    Almacen almacen = new Almacen();
    Ingreso ingreso = new Ingreso();
    Venta venta = new Venta();

    ArrayList<Almacen> listaAlmacen = new ArrayList<>();
    ArrayList<Ingreso> listaIngresos = new ArrayList<>();
    ArrayList<Venta> listaVentas = new ArrayList<>();

    public void crearProducto(String nombre, int cantidad){

        listaAlmacen.add(new Almacen(nombre, cantidad));
    }

    public void abastecerProducto(String nombre, int cantidad){
        ingreso.setNombre(nombre);
        ingreso.setCantidad(cantidad);
        listaIngresos.add(new Ingreso(nombre, cantidad)); // Agregar ingreso a la lista de ingresos

        boolean existe = false;
        for (Almacen value : listaAlmacen)
            if (value.getNombre().equals(ingreso.getNombre())) {
                value.setCantidad(value.getCantidad() + ingreso.getCantidad());
                existe = true;
            }
        if(!existe)
            System.out.println("El producto no existe");
    } //---------

    public void venderProducto(String nombre, int cantidad){
        venta.setNombre(nombre);
        venta.setCantidad(cantidad);
        listaVentas.add(new Venta(nombre,cantidad)); // Agregar venta a la lista de ventas

        for (int i = 0; i < listaAlmacen.size(); i++) {
            if (listaAlmacen.get(i).getNombre().equals(venta.getNombre())) {
                if(listaAlmacen.get(i).getCantidad() >= venta.getCantidad()){
                    listaAlmacen.get(i).setCantidad(listaAlmacen.get(i).getCantidad() - venta.getCantidad());
                }else{
                    System.out.println("No hay suficientes productos");
                }
            }
        }
    }



    public void mostrarProductos(){ //Mostrar productos en almacen
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Almacen value : listaAlmacen)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }

    public void mostrarIngresos(){ //Mostrar ingresos de productos
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Ingreso value : listaIngresos)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }

    public void mostrarVentas(){ //Mostrar ventas de productos
        System.out.printf("\n%-10s %10s\n", " Nombre", "Cantidad");
        for (Venta value : listaVentas)
            System.out.printf("|%-10s|%10d|\n", value.getNombre() , value.getCantidad());
    }



    public void destruirProducto(String nombre){
        for (int i = 0; i < listaAlmacen.size(); i++) {
            if (listaAlmacen.get(i).getNombre().equals(nombre)) {
                listaAlmacen.remove(i);
            }
        }
    }
}
