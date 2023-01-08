package com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.User;
import org.hibernate.cfg.NotYetImplementedException;

public class LoggedUserMapper implements IMapper<User, LoggedUserDTO> {
    @Override
    public LoggedUserDTO toDTO(User entity) {
        return new LoggedUserDTO(entity.getName().getFirstName(),
                entity.getName().getSurname(),
                entity.getEmail().getAddress(),
                new RoleMapper().toDTO(entity.getRole()));
    }

    @Override
    public User toEntity(LoggedUserDTO dto) {
        throw new NotYetImplementedException();
    }
}
