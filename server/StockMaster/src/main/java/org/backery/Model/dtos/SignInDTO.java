package org.backery.Model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class SignInDTO {
    @NotBlank(message = "user identifier is mandatory")
    private String identifier;

    @NotBlank(message = "user password is mandatory")
    private String password;

    public SignInDTO() {
        super();
    }

}
