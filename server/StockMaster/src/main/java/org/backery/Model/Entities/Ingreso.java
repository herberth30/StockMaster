package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@AllArgsConstructor
public class Ingreso extends Process{

    public Ingreso(String nombre, int cantidad) {
        super(nombre, cantidad);
    }
}
