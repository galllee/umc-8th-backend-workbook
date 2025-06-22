package com.example.umc.umc_8th.service.user;

import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.dto.response.UserResponseDTO;
import com.example.umc.umc_8th.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO.UserInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return UserConverter.toMemberInfoDTO(user);
    }
}
