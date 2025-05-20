package com.example.umc.umc_8th.dto.request;

import com.example.umc.umc_8th.domain.FoodCategory;
import com.example.umc.umc_8th.domain.Region;
import com.example.umc.umc_8th.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDto {
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @NotNull
        //@ExistRegion
        private Long regionId;
        //@ExistCategories // 음식 장르가 여러개일 수는 없지만 이걸로 처리 할 수 있음 (근데 그냥 Long도 되나?)
        private Long foodCategoryId;
    }
}
