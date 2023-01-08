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
public class UserDTO implements IDTO {
    private String firstName;
    private String surname;
    private Integer cellphone;
    private String email;
    private String password;
    private RoleDTO roleDTO;

    @JsonCreator
    public UserDTO(@JsonProperty("First Name") String firstName,
                         @JsonProperty("Surname") String surname,
                         @JsonProperty("Cellphone") Integer cellphone,
                         @JsonProperty("Email") String email,
                         @JsonProperty("Password") String password,
                         @JsonProperty("Role") RoleDTO roleDTO) {
        this.firstName = firstName;
        this.surname = surname;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.roleDTO = roleDTO;
    }
}