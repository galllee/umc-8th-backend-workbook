package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateStoreDto request);
    AcceptedMission createAcceptedMission(StoreRequestDTO.AcceptMissionDTO request, Long missionId);
}
