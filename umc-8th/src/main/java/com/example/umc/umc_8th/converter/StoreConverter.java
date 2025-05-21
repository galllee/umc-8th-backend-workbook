package com.example.umc.umc_8th.converter;

import com.example.umc.umc_8th.domain.*;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Region;
import com.example.umc.umc_8th.domain.Store;
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


    public static StoreResponseDTO.CreateMissionDTO toCreateMissionDTO(Mission mission) {
        return StoreResponseDTO.CreateMissionDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.CreateReviewDTO toCreateReviewDTO(Review review) {
        return StoreResponseDTO.CreateReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.CreateMissionDTO request, Store store) {
        return Mission.builder()
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .store(store)
                .detail(request.getDetail())
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

    public static StoreResponseDTO.AcceptMissionDTO toAcceptMissionDTO(AcceptedMission acceptedMission) {
        return StoreResponseDTO.AcceptMissionDTO.builder()
                .acceptedMissionId(acceptedMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static AcceptedMission toAcceptedMission(StoreRequestDTO.AcceptMissionDTO request, User user, Mission mission) {
        return AcceptedMission.builder()
                .user(user)
                .mission(mission)
                .build();
    }
}
