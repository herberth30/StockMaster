package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Process {
    private int id;
    private String nombre;
    private int cantidad;

    public Process() {
    }

    public Process(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
}
