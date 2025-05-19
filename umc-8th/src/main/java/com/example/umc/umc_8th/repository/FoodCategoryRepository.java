package com.example.umc.umc_8th.repository;

import com.example.umc.umc_8th.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
