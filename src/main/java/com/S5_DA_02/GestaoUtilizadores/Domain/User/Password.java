package com.S5_DA_02.GestaoUtilizadores.Domain.User;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@Getter
@ToString
public class Password {
    @NotNull
    private String text;

    public Password(String text) {
        this.text = text;
    }
}
