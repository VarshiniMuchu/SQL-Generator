package com.varshini.sqlgenerator.repository;

import com.varshini.sqlgenerator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByEmail(String email);
}