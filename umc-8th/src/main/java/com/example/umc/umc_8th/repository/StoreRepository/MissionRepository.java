package com.example.umc.umc_8th.repository.StoreRepository;

import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}

