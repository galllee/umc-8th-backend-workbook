package com.example.umc.umc_8th.controller;

import com.example.umc.umc_8th.apiPayload.ApiResponse;
import com.example.umc.umc_8th.converter.StoreConverter;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.dto.response.StoreResponseDTO;
import com.example.umc.umc_8th.repository.StoreRepository.StoreRepository;
import com.example.umc.umc_8th.service.store.StoreCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    //지역에 가게 추가
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDto request) {
        Store store = storeCommandService.createStore(request);

        return ApiResponse.onSuccess(StoreConverter.toCreateStoreDTO(store));
    }


    //가게에 리뷰 추가

    //가게에 미션 추가

    //가게의 미션을 도전 중인 미션에 추가 (미션 도전하기)
}
