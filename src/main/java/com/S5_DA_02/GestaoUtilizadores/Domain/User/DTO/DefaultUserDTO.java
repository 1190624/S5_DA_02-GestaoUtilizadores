package com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class DefaultUserDTO {
    private Integer cellphone;

    @JsonCreator
    public DefaultUserDTO(@JsonProperty("Cellphone") Integer cellphone) {
        this.cellphone = cellphone;
    }
}
