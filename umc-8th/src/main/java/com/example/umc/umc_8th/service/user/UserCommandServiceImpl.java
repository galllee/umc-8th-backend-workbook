package com.example.umc.umc_8th.service.user;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDTO request) {
        User newUser = UserConverter.toUser(request);

        newUser.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        //여기서도 결국 존재 여부를 또 검사 해주니까.. 커스텀 어노테이션 필요가 없는듯

        List<FoodPreference> foodPreferList = FoodPreferConverter.toFoodPreferList(foodCategoryList);

        foodPreferList.forEach(foodPrefer -> {foodPrefer.setUser(newUser);});

        return userRepository.save(newUser);
        // 미리 food category를 찾아와서 컨버터 함수에 넣어주는 방식으로 수정하고 싶음
    }
}
