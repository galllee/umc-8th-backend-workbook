package com.example.umc.umc_8th.service.user;

import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.dto.request.UserRequestDTO;
import com.example.umc.umc_8th.dto.response.UserResponseDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDTO request);
    UserResponseDTO.LoginResultDTO loginUser(UserRequestDTO.LoginRequestDTO request);
}
