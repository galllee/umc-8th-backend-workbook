package com.example.umc.umc_8th.repository.StoreRepository;

import com.example.umc.umc_8th.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
