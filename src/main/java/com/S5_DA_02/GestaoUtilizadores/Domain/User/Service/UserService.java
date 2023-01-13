package com.S5_DA_02.GestaoUtilizadores.Domain.User.Service;

import com.S5_DA_02.GestaoUtilizadores.Common.IService;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleDTO;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Repository.IRoleRepo;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Role;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.DTO.*;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.Repository.IUserRepo;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IService<UserDTO> {
    private static final String DEFAULT_FIRST_NAME = "John";
    private static final String DEFAULT_SURNAME_NAME = "Doe";
    private static final String DEFAULT_EMAIL = "electricgo";
    private static final String DEFAULT_PASSWORD = "ElectricGo";
    private static final String DEFAULT_ROLE = "DEFAULT";

    private final IUserRepo userRepo;
    private final IRoleRepo roleRepo;

    public RegisteredUserDTO saveEntity(UserDTO dto) {
        Role role = roleRepo.getRoleByDesignation(dto.getRoleDTO().getDesignation());
        User user = new UserMapper().toEntity(dto);

        user.setRole(role);

        try {
            return new RegisteredUserMapper().toDTO(userRepo.save(user));
        } catch (DataAccessException exception) {
            return null;
        }
    }

    public LoggedUserDTO loginUser(LoginUserDTO loginDTO) {
        User user = userRepo.getUserByEmail(loginDTO.getEmail());

        if (user != null && user.getPassword().equals(loginDTO.getPassword()) && user.isAccountNonExpired())
            return new LoggedUserMapper().toDTO(user);

        return null;
    }

    public RegisteredUserDTO saveUserByAdmin(DefaultUserDTO defaultUserDTO) {
        Role role = roleRepo.getRoleByDesignation(DEFAULT_ROLE);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(DEFAULT_EMAIL).append(userRepo.count() + 1).append("@electricgo.com");

        UserDTO userDTO = new UserDTO(DEFAULT_FIRST_NAME,
                DEFAULT_SURNAME_NAME,
                defaultUserDTO.getCellphone(),
                stringBuilder.toString(),
                DEFAULT_PASSWORD,
                new RoleDTO(DEFAULT_ROLE)
                );
        User user = new UserMapper().toEntity(userDTO);

        user.setRole(role);

        try {
            return new RegisteredUserMapper().toDTO(userRepo.save(user));
        } catch (DataAccessException exception) {
            return null;
        }
    }

    public LoggedUserDTO checkUserAuthorization(String email) {
        try {
            return new LoggedUserMapper().toDTO(userRepo.getUserByEmail(email));
        } catch (DataAccessException exception) {
            return null;
        }
    }
}
