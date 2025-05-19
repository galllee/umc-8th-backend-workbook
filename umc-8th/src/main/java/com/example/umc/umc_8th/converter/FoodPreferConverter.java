package com.example.umc.umc_8th.converter;

import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.mapping.FoodPreference;
import com.example.umc.umc_8th.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class FoodPreferConverter {

    public static List<FoodPreference> toFoodPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream().map(foodCategory -> FoodPreference.builder()
                    .foodCategory(foodCategory)
                    .build()
        ).collect(Collectors.toList());
    }
}
