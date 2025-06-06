package com.example.umc.umc_8th.domain.mapping;

import com.example.umc.umc_8th.domain.AcceptedMissionStatus;
import com.example.umc.umc_8th.domain.Mission;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptedMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'IN_PROGRESS'")
    private AcceptedMissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void completeMission() {
        this.status = AcceptedMissionStatus.COMPLETED;
    }
}
