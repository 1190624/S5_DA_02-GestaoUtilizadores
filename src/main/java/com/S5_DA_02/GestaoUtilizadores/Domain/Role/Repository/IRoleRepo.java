package com.S5_DA_02.GestaoUtilizadores.Domain.Role.Repository;

import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Long> {
    @Query("SELECT role FROM Role role WHERE role.designation.text = ?1")
    Role getRoleByDesignation(String designation);
}
