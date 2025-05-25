package com.example.umc.umc_8th.repository.StoreRepository;

import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.domain.mapping.AcceptedMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcceptedMissionRepository extends JpaRepository<AcceptedMission, Long> {
    boolean existsByMissionId(Long missionId);
    Page<AcceptedMission> findAllByUser(User user, PageRequest pageRequest);
}
