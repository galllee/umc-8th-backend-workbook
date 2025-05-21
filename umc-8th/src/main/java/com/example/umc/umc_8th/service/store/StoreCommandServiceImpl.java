package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.converter.StoreConverter;
import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Region;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.repository.FoodCategoryRepository;
import com.example.umc.umc_8th.repository.RegionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.MissionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    public Store createStore(StoreRequestDTO.CreateStoreDto request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("해당하는 지역이 없습니다."));

        FoodCategory foodCategory = foodCategoryRepository.findById(request.getFoodCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당하는 음식 카테고리가 없습니다."));

        Store newStore = StoreConverter.toStore(request, region, foodCategory);

        return storeRepository.save(newStore);
    }

    public Mission createMission(StoreRequestDTO.CreateMissionDTO request, Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 가게가 없습니다."));

        Mission newMission = StoreConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }
}
