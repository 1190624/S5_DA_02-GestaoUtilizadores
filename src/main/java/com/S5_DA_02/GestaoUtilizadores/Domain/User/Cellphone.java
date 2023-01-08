package com.S5_DA_02.GestaoUtilizadores.Domain.User;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Cellphone {
    @NotNull
    @Min(value = 900000000, message = "Número deve começar pelo algarismo 9 e deve conter apenas 9 algarismos;")
    @Max(value = 999999999, message = "Número deve começar pelo algarismo 9 e deve conter apenas 9 algarismos;")
    private Integer number;

    public Cellphone(Integer number) {
        this.number = number;
    }

    public String toString() {
        return number.toString();
    }
}
