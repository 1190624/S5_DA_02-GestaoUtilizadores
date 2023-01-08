package com.S5_DA_02.GestaoUtilizadores.Domain.Role;

import jakarta.persistence.*;

@Entity
@Table(name = "Role_Table", uniqueConstraints = { @UniqueConstraint(columnNames = {"text"}) })
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Designation designation;

    protected Role() {}

    public Role(Designation designation) {
        this.designation = designation;
    }

    public Designation getDesignation() {
        return designation;
    }
}
