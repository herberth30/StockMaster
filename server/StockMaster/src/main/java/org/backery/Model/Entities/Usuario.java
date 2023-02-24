package org.backery.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Usuario {
    int id;
    String name;
    String email;
    String username;
    String password;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String usuario, String contrasena) {
        this.name = nombre;
        this.email = correo;
        this.username = usuario;
        this.password = contrasena;
    }
}
