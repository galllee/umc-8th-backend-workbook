package com.example.umc.umc_8th.service;

import com.example.umc.umc_8th.apiPayload.code.status.ErrorStatus;
import com.example.umc.umc_8th.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc.umc_8th.converter.FoodPreferConverter;
import com.example.umc.umc_8th.converter.UserConverter;
import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.domain.mapping.FoodPreference;
import com.example.umc.umc_8th.dto.request.UserRequestDTO;
import com.example.umc.umc_8th.repository.FoodCategoryRepository;
import com.example.umc.umc_8th.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<FoodPreference> foodPreferList = FoodPreferConverter.toFoodPreferList(foodCategoryList);

        foodPreferList.forEach(foodPrefer -> {foodPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
