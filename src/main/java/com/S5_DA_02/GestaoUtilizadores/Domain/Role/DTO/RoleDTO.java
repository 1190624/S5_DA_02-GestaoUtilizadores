package com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO implements IDTO {
    private String designation;

    @JsonCreator
    public RoleDTO(@JsonProperty("Designation") String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
