package com.example.umc.umc_8th.validation.annotation;

import com.example.umc.umc_8th.validation.validator.MissionAlreadyAcceptedValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionAlreadyAcceptedValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAlreadyAccepted {
    String message() default "이거?미션이 이미 진행 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
