package com.S5_DA_02.GestaoUtilizadores.Domain.User.Repository;

import com.S5_DA_02.GestaoUtilizadores.Domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.email.address = ?1")
    User getUserByEmail(String email);
}
