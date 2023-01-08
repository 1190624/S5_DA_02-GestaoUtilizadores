package com.S5_DA_02.GestaoUtilizadores.Domain.User;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@Getter
@ToString
public class Email {
    @NotNull
    @Pattern(regexp = "[a-z]+(\\.?[a-z]+)*@[a-z]+\\.(com|pt|fr)")
    private String address;

    public Email(String address) {
        this.address = address;
    }
}
