package com.example.umc.umc_8th.controller;

import com.example.umc.umc_8th.apiPayload.ApiResponse;
import com.example.umc.umc_8th.converter.StoreConverter;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.dto.response.StoreResponseDTO;
import com.example.umc.umc_8th.service.store.StoreCommandService;
import com.example.umc.umc_8th.validation.annotation.ExistStore;
import com.example.umc.umc_8th.validation.annotation.NotAlreadyAccepted;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    //지역에 가게 추가
    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        Store store = storeCommandService.createStore(request);

        return ApiResponse.onSuccess(StoreConverter.toCreateStoreDTO(store));
    }

    //가게에 리뷰 추가
    @PostMapping("{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewDTO> createReview(@RequestBody @Valid StoreRequestDTO.CreateReviewDTO request, @PathVariable @ExistStore Long storeId) {
        Review review = storeCommandService.createReview(request, storeId);

        return ApiResponse.onSuccess(StoreConverter.toCreateReviewDTO(review));
    }

    //가게에 미션 추가
    @PostMapping("{storeId}/missions")
    public ApiResponse<StoreResponseDTO.CreateMissionDTO> createMission(@RequestBody @Valid StoreRequestDTO.CreateMissionDTO request, @PathVariable @ExistStore Long storeId) {
        Mission mission = storeCommandService.createMission(request, storeId);

        return ApiResponse.onSuccess(StoreConverter.toCreateMissionDTO(mission));
    }
    //가게의 미션을 도전 중인 미션에 추가 (미션 도전하기)
    @PostMapping("/missions/{missionId}") // storeId가 필요할까? missioncontroller로 독립해도 괜찮을듯
    public ApiResponse<StoreResponseDTO.AcceptMissionDTO> acceptMission(@RequestBody @Valid StoreRequestDTO.AcceptMissionDTO request, @PathVariable @NotAlreadyAccepted Long missionId) {
        AcceptedMission acceptedMission = storeCommandService.createAcceptedMission(request, missionId);

        return ApiResponse.onSuccess(StoreConverter.toAcceptMissionDTO(acceptedMission));
    }

}
