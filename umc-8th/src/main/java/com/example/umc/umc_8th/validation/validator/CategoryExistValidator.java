package com.example.umc.umc_8th.validation.validator;

import com.example.umc.umc_8th.apiPayload.code.status.ErrorStatus;
import com.example.umc.umc_8th.repository.FoodCategoryRepository;
import com.example.umc.umc_8th.validation.annotation.ExistCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryExistValidator implements ConstraintValidator<ExistCategory, Long> {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
