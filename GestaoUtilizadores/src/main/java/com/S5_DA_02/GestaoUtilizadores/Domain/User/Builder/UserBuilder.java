package com.S5_DA_02.GestaoUtilizadores.Domain.User.Builder;

import com.S5_DA_02.GestaoUtilizadores.Common.IBuilder;
import com.S5_DA_02.GestaoUtilizadores.Domain.User.*;

public class UserBuilder implements IBuilder<User> {
    private RegistrationDate registrationDate;
    private Name name;
    private Cellphone cellphone;
    private Email email;
    private Password password;

    public UserBuilder setRegistrationDate() {
        this.registrationDate = new RegistrationDate();

        return this;
    }

    public UserBuilder setName(String firstName, String surname) {
        this.name = new Name(firstName, surname);

        return this;
    }

    public UserBuilder setCellphone(Integer cellphone) {
        this.cellphone = new Cellphone(cellphone);

        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = new Email(email);

        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = new Password(password);

        return this;
    }

    @Override
    public User build() {
        return new User(registrationDate, name, cellphone, email, password);
    }
}
