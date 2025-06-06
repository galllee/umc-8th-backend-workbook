package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long storeId, Integer page);
    Page<Review> getReviewListByUserId(Long storeId, Long userId, Integer page);
    Page<Mission> getMissionListByStoreId(Long storeId, Integer page);
    Page<AcceptedMission> getMissionListByUserId(Long userId, Integer page);
}
