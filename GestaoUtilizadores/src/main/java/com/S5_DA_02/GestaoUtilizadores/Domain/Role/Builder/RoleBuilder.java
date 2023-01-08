package com.S5_DA_02.GestaoUtilizadores.Domain.Role.Builder;

import com.S5_DA_02.GestaoUtilizadores.Common.IBuilder;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Designation;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Role;

public class RoleBuilder implements IBuilder {
    private Designation designation;

    public RoleBuilder setDesignation(String designation) {
        this.designation = new Designation(designation);

        return this;
    }

    @Override
    public Role build() {
        return new Role(designation);
    }
}
