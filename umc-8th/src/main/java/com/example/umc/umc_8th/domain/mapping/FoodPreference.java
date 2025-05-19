package com.example.umc.umc_8th.domain.mapping;

import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.User;
import com.example.umc.umc_8th.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodPreference extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;

    public void setUser(User user) {
        if (this.user != null) {
            user.getFoodPreferList().remove(this);
        }
        this.user = user;
        user.getFoodPreferList().add(this);
    }
    //양방향 매핑 연관관계 편의 메소드

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
