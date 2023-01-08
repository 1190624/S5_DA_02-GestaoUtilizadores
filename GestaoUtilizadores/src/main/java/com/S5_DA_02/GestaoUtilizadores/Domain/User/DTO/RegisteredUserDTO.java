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
public class RegisteredUserDTO implements IDTO {
    private String firstName;
    private String surname;
    private Integer cellphone;
    private String email;
    private RoleDTO roleDTO;

    @JsonCreator
    public RegisteredUserDTO(@JsonProperty("First Name") String firstName,
                   @JsonProperty("Surname") String surname,
                   @JsonProperty("Cellphone") Integer cellphone,
                   @JsonProperty("Email") String email,
                   @JsonProperty("Role") RoleDTO roleDTO) {
        this.firstName = firstName;
        this.surname = surname;
        this.cellphone = cellphone;
        this.email = email;
        this.roleDTO = roleDTO;
    }
}
