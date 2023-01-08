package com.S5_DA_02.GestaoUtilizadores.Domain.Role;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Designation {
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+( [A-Z][a-z]+)*")
    private String text;

    protected Designation() {}

    public Designation(String text) {
        this.text = text;
    }

    private void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return text;
    }
}
