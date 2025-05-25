package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.converter.StoreConverter;
import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Region;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.*;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import com.example.umc.umc_8th.dto.request.StoreRequestDTO;
import com.example.umc.umc_8th.repository.FoodCategoryRepository;
import com.example.umc.umc_8th.repository.RegionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.MissionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.ReviewRepository;
import com.example.umc.umc_8th.repository.StoreRepository.AcceptedMissionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.StoreRepository;
import com.example.umc.umc_8th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final AcceptedMissionRepository acceptedMissionRepository;

    public Store createStore(StoreRequestDTO.CreateStoreDTO request) {
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

    public Review createReview(StoreRequestDTO.CreateReviewDTO request, Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 가게가 없습니다."));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당하는 사용자가 없습니다."));

        Review newReview = StoreConverter.toReview(request, store, user);

        return reviewRepository.save(newReview);
    }

    public AcceptedMission createAcceptedMission(StoreRequestDTO.AcceptMissionDTO request, Long missionId) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당하는 사용자가 없습니다."));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 미션이 없습니다."));

        AcceptedMission newAcceptedMission = StoreConverter.toAcceptedMission(request, user, mission);

        return acceptedMissionRepository.save(newAcceptedMission);
    }

    @Transactional
    public AcceptedMission completeMission(Long acceptedMissionId) {
        AcceptedMission acceptedMission = acceptedMissionRepository.findById(acceptedMissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 진행 중인 미션이 없습니다."));

        if (acceptedMission.getStatus() == AcceptedMissionStatus.COMPLETED) {
            throw new IllegalStateException("이미 완료된 미션입니다.");
        }

        acceptedMission.completeMission();

        return acceptedMission;
    }
}
