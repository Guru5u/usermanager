package com.usermanager.usermanager.repository;

import com.usermanager.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMangerRepository extends JpaRepository<User, Integer> {
}
