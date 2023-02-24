package org.backery.Model.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class SignUpDTO {
//    int id;
    @NotBlank(message = "user name is mandatory")
    @Size(min = 5, max=50, message = "user name should have at least 5 characters")
    String name;
    @NotBlank(message = "user email is mandatory")
//    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
    @Email(message = "Email should be valid")
    String email;
    @NotBlank(message = "user username is mandatory")
    @Size(min = 5, max=10, message = "user username should have at least 5 characters")
    String username;


    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
                      message = "Password should have at least 8 characters, one uppercase, " +
                                "one lowercase, one number and one special character")
    @NotBlank(message = "user username is mandatory")
    @Size(min = 5, max=10, message = "user password should have at least 5 characters")
    String password;
}