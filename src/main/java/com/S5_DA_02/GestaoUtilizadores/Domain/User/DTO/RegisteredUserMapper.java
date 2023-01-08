package com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.User;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

@Component
public class RegisteredUserMapper implements IMapper<User, RegisteredUserDTO> {
    @Override
    public RegisteredUserDTO toDTO(User entity) {
        return new RegisteredUserDTO(entity.getName().getFirstName(),
                entity.getName().getSurname(),
                entity.getCellphone().getNumber(),
                entity.getEmail().getAddress(),
                new RoleMapper().toDTO(entity.getRole()));
    }

    @Override
    public User toEntity(RegisteredUserDTO dto) {
        throw new NotYetImplementedException();
    }
}
