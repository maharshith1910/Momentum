package com.maharshith.backend.repository;

import com.maharshith.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long > {
}
