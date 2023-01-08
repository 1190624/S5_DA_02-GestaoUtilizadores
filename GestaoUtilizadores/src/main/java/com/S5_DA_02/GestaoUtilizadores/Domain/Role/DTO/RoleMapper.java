package com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Builder.RoleBuilder;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Role;

public class RoleMapper implements IMapper<Role, RoleDTO> {
    @Override
    public RoleDTO toDTO(Role entity) {
        return new RoleDTO(entity.getDesignation().getText());
    }

    @Override
    public Role toEntity(RoleDTO dto) {
        return new RoleBuilder().setDesignation(dto.getDesignation()).build();
    }
}
