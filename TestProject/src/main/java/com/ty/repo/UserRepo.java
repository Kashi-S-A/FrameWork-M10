package com.ty.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
}
