package com.S5_DA_02.GestaoUtilizadores.Domain.User;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Name {
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+", message = "The First Name must start with a upper case letter and mustn't contain special characters;")
    private String firstName;
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+", message = "The Surname must start with a upper case letter and mustn't contain special characters;")
    private String surname;

    public Name(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String toString() {
        return  new StringBuilder().append(firstName).append(" ").append(surname).toString();
    }
}
