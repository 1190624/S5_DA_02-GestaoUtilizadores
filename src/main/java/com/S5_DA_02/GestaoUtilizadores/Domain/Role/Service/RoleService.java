package com.S5_DA_02.GestaoUtilizadores.Domain.Role.Service;

import com.S5_DA_02.GestaoUtilizadores.Common.IDTO;
import com.S5_DA_02.GestaoUtilizadores.Common.IService;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleDTO;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleMapper;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Repository.IRoleRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService implements IService<RoleDTO> {
    private final IRoleRepo roleRepo;

    @Autowired
    public RoleService(IRoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public RoleDTO saveEntity(RoleDTO roleDTO) {
        return new RoleMapper().toDTO(roleRepo.save(new RoleMapper().toEntity(roleDTO)));
    }

    public List<RoleDTO> getAllEntities() {
        List<RoleDTO> roleDTOList = new ArrayList<>();

        roleDTOList.addAll(roleRepo.findAll().stream().map(entity -> new RoleMapper().toDTO(entity)).collect(Collectors.toList()));

        return roleDTOList;
    }

    public void deleteEntity(RoleDTO roleDTO) {
        roleRepo.delete(new RoleMapper().toEntity(roleDTO));
    }
}
