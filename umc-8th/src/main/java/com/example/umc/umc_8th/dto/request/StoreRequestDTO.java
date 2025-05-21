package com.example.umc.umc_8th.dto.request;

import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.Region;
import com.example.umc.umc_8th.validation.annotation.ExistCategories;
import com.example.umc.umc_8th.validation.annotation.ExistCategory;
import com.example.umc.umc_8th.validation.annotation.ExistRegion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @NotNull
        //@ExistRegion
        private Long regionId;
        @NotNull
        //@ExistCategory
        private Long foodCategoryId;
    }

    @Getter
    public static class CreateMissionDTO {
        @NotNull
        private Integer point;
        @NotNull
        private LocalDate deadline;
        @NotBlank
        private String detail;
    }

    public static class CreateReviewDTO {
        @NotNull
        private Long userId;
        @NotNull
        private Float score;
        @Size(min = 1, max = 200)
        private String detail;
    }

    @Getter
    public static class AcceptMissionDTO {
        @NotNull
        private Long userId;
    }
}
