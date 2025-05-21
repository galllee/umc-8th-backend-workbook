package com.example.umc.umc_8th.service.user;

import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.dto.request.UserRequestDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDTO request);
}
