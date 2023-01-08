package com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IDTO;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoggedUserDTO implements IDTO {
    private String firstName;
    private String surname;
    private String email;
    private RoleDTO roleDTO;

    @JsonCreator
    public LoggedUserDTO(@JsonProperty("First Name") String firstName,
                         @JsonProperty("Surname") String surname,
                         @JsonProperty("Email") String email,
                         RoleDTO roleDTO) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.roleDTO = roleDTO;
    }
}
