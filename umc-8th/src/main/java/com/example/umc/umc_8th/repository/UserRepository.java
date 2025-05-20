package com.example.umc.umc_8th.repository;

import com.example.umc.umc_8th.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
