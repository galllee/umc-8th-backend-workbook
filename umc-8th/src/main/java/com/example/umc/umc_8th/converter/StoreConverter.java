package com.example.umc.umc_8th.converter;

import com.example.umc.umc_8th.domain.*;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
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

    public static Store toStore(StoreRequestDTO.CreateStoreDto request, Region region, FoodCategory foodCategory) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .foodCategory(foodCategory)
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
