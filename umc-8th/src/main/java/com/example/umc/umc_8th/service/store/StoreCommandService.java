package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;

import javax.accessibility.AccessibleTable;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateStoreDTO request);
    AcceptedMission createAcceptedMission(StoreRequestDTO.AcceptMissionDTO request, Long missionId);
    Mission createMission(StoreRequestDTO.CreateMissionDTO request, Long storeId);
    Review createReview(StoreRequestDTO.CreateReviewDTO request, Long storeId);
    AcceptedMission completeMission(Long acceptedMissionId);
}
