package com.example.umc.umc_8th.controller;

import com.example.umc.umc_8th.apiPayload.ApiResponse;
import com.example.umc.umc_8th.converter.UserConverter;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.dto.request.UserRequestDTO;
import com.example.umc.umc_8th.dto.response.UserResponseDTO;
import com.example.umc.umc_8th.service.user.UserCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    // 회원가입 api
    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDTO request) {
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }
}
