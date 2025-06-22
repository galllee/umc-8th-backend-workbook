package com.example.umc.umc_8th.service.user;

import com.example.umc.umc_8th.dto.response.UserResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserQueryService {
    UserResponseDTO.UserInfoDTO getMemberInfo(HttpServletRequest request);
}
