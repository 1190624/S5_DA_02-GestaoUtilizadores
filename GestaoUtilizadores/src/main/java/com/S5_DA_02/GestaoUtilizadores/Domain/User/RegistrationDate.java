package com.S5_DA_02.GestaoUtilizadores.Domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Embeddable
@Getter
public class RegistrationDate {
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime date;

    public RegistrationDate() {
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
