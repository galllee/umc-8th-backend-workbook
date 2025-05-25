package com.example.umc.umc_8th.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Target( ElementType.PARAMETER )
@Retention(RetentionPolicy.RUNTIME)
public @interface PageParam {
    String message() default "페이지 숫자는 1부터 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
