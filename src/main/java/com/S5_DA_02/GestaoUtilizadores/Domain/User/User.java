package com.S5_DA_02.GestaoUtilizadores.Domain.User;

import com.S5_DA_02.GestaoUtilizadores.Domain.Role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User_Table",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"address", "number"}) })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Seq")
    @SequenceGenerator(name = "User_Seq", sequenceName = "User_Seq")
    private Long id;
    @Embedded
    private RegistrationDate registrationDate;
    @Embedded
    private Name name;
    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "number", nullable = false))
    private Cellphone cellphone;
    @Embedded
    private Email email;
    @Embedded
    private Password password;
    @ManyToOne
    private Role role;
    private Boolean accountEnabled;
    private Boolean accountNotExpired;
    private Boolean accountNotLocked;
    private Boolean credentialsNonExpired;

    protected User() {}

    public User(RegistrationDate registrationDate,
                Name name,
                Cellphone cellphone,
                Email email,
                Password password)
    {
        this.registrationDate = registrationDate;
        this.name = name;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.accountEnabled = true;
        this.accountNotExpired = true;
        this.accountNotLocked = true;
        this.credentialsNonExpired = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getDesignation().getText()));
    }

    @Override
    public String getPassword() {
        return password.getText();
    }

    @Override
    public String getUsername() {
        return email.getAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return accountEnabled;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public RegistrationDate getRegistrationDate() {
        return registrationDate;
    }

    public Name getName() {
        return name;
    }

    public Cellphone getCellphone() {
        return cellphone;
    }

    public Email getEmail() {
        return email;
    }


    public Role getRole() {
        return role;
    }
}
