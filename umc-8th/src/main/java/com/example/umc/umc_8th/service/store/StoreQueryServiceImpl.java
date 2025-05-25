package com.example.umc.umc_8th.service.store;

import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.repository.StoreRepository.MissionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.ReviewRepository;
import com.example.umc.umc_8th.repository.StoreRepository.StoreRepository;
import com.example.umc.umc_8th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        //Store store = storeRepository.findById(storeId).get();
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 없습니다."));

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Review> getReviewListByUserId(Long storeId, Long userId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 없습니다."));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        Page<Review> storePage = reviewRepository.findAllByStoreAndUser(store, user, PageRequest.of(page, 10));

        return storePage;
    }

    @Override
    public Page<Mission> getMissionListByStoreId(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 없습니다."));

        Page<Mission> storePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));

        return storePage;
    }

}
