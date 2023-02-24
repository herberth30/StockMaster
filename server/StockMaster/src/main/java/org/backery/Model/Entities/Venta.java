package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Venta extends Process{

    public Venta(String nombre, int cantidad) {
        super(nombre, cantidad);
    }
}