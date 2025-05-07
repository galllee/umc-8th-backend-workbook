package com.example.umc.umc_8th.repository.StoreRepository;

import com.example.umc.umc_8th.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
