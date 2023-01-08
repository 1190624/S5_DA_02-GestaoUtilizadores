package com.S5_DA_02.GestaoUtilizadores;

import com.S5_DA_02.GestaoUtilizadores.Domain.User.Password;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class GestaoUtilizadoresApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestaoUtilizadoresApplication.class, args);
	}
}
