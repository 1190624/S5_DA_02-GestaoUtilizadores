package com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO;

import com.S5_DA_02.GestaoUtilizadores.Common.IMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.Builder.UserBuilder;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class UserMapper implements IMapper<User, UserDTO> {
    @Override
    public UserDTO toDTO(@NotNull User user) {
        return new UserDTO(user.getName().getFirstName(),
                user.getName().getSurname(),
                user.getCellphone().getNumber(),
                user.getEmail().getAddress(),
                user.getPassword(),
                new RoleMapper().toDTO(user.getRole()));
    }

    @Override
    public User toEntity(@NotNull UserDTO userDTO) {
        UserBuilder userBuilder = new UserBuilder();

        userBuilder.setRegistrationDate()
                .setName(userDTO.getFirstName(), userDTO.getSurname())
                .setCellphone(userDTO.getCellphone())
                .setEmail(userDTO.getEmail())
                .setPassword(userDTO.getPassword());

        return userBuilder.build();
    }
}
