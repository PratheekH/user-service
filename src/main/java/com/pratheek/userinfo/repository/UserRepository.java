package com.pratheek.userinfo.repository;

import com.pratheek.userinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
