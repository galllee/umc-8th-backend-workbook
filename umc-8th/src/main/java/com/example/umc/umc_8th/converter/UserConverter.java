package com.example.umc.umc_8th.converter;

import com.example.umc.umc_8th.domain.Gender;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.dto.request.UserRequestDTO;
import com.example.umc.umc_8th.dto.response.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now()) // 멤버 생성 시간
                .build();
    }

    //유저 생성
    public static User toUser(UserRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .foodPreferList(new ArrayList<>())
                .build();
    }
}
