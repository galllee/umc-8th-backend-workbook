package com.example.umc.umc_8th.service;

import com.example.umc.umc_8th.converter.UserConverter;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.dto.request.UserRequestDTO;
import com.example.umc.umc_8th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    public User joinUser(UserRequestDTO.JoinDto request) {
        User user = UserConverter.toUser(request);

        return null;
    }
}
