package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateStoreDTO request);
    Review createReview(StoreRequestDTO.CreateReviewDTO request, Long storeId);
}
