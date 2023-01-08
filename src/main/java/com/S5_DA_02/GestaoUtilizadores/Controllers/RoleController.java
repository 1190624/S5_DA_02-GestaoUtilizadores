package com.S5_DA_02.GestaoUtilizadores.Controllers;

import com.S5_DA_02.GestaoUtilizadores.Domain.Role.DTO.RoleDTO;
import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/role/save")
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(roleService.saveEntity(roleDTO));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllEntities());
    }
}
