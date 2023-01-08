package com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
public class LoginUserDTO implements IDTO {
    private String email;
    private String password;

    @JsonCreator
    public LoginUserDTO(@JsonProperty("Email") String email, @JsonProperty("Password") String password) {
        this.email = email;
        this.password = password;
    }
}
