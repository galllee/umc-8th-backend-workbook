package com.example.umc.umc_8th.converter;

import com.example.umc.umc_8th.domain.*;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.dto.response.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreDTO toCreateStoreDTO(Store store) {
        return StoreResponseDTO.CreateStoreDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateStoreDTO request, Region region, FoodCategory foodCategory) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .foodCategory(foodCategory)
                .build();
    }

    public static StoreResponseDTO.CreateReviewDTO toCreateReviewDTO(Review review) {
        return StoreResponseDTO.CreateReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.CreateReviewDTO request, Store store, User user) {
        return Review.builder()
                .user(user)
                .store(store)
                .score(request.getScore())
                .detail(request.getDetail())
                .build();
    }
}
