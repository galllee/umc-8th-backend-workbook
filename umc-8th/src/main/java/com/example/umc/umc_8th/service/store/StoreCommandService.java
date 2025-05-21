package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateStoreDto request);
    Mission createMission(StoreRequestDTO.CreateMissionDTO request, Long storeId);
    Review createReview(StoreRequestDTO.CreateReviewDTO request, Long storeId);
}
