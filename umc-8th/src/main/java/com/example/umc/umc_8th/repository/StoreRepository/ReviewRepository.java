package com.example.umc.umc_8th.repository.StoreRepository;

import com.example.umc.umc_8th.domain.Review;
import com.example.umc.umc_8th.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
